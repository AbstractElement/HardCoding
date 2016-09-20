package com.application.controllers;

import com.application.dao.PostsDAO;
import com.application.dao.ProfileDAO;
import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.validators.PostsValidator;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Vladislav on 11.09.2016.
 */

@Controller
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostsValidator postsValidator;

    @Autowired
    private ProfileDAO profileDAO;

    @Autowired
    private PostsDAO postsDAO;

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String toNewPost(Model model){
        model.addAttribute("post", new Posts());
        return "addPost";
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String saveNewPost(Model model,
                              HttpSession session,
                              @ModelAttribute("post") Posts post,
                              BindingResult result) throws Exception {
        postsValidator.validate(post, result);
        if (result.hasErrors()) {
            model.addAttribute("post", post);
            return "addPost";
        }
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        Profile tableProfile = profileDAO.viewThisProfileFromUserId(idUser);
        post.setTimeOfPublication(new Date());
        post.setProfile(tableProfile);
        post.setOwnerPost(tableProfile.getCurrentUser().getEmail());
        postsDAO.createPost(post);
        model.addAttribute("posts", postsDAO.retrievePostsByProfileId(idUser));
        model.addAttribute("profile", profileDAO.viewThisProfileFromUserId(idUser));
        return "profilePage";
    }

    @RequestMapping(value = "/delete/{idPost}", method = RequestMethod.GET)
    public String deletePost(Model model,
                             HttpSession session,
                             @PathVariable int idPost) throws Exception {
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        postsDAO.deletePost(idPost);
        model.addAttribute("profile", profileDAO.viewThisProfileFromUserId(idUser));
        model.addAttribute("posts", postsDAO.retrievePostsByProfileId(idUser));
        return "profilePage";
    }

    @RequestMapping(value = "/edit/{idPost}", method = RequestMethod.GET)
    public String editPost(Model model,
                           HttpSession session,
                           @PathVariable String idPost) throws Exception {
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        Posts post = postsDAO.retrievePostById(idPost);
        model.addAttribute("editPost", post);
        model.addAttribute("posts", postsDAO.retrievePostsByProfileId(idUser));
        model.addAttribute("profile", profileDAO.viewThisProfileFromUserId(idUser));
        return "profilePage";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditPost(Model model,
                               HttpSession session,
                               @ModelAttribute("editPost") Posts post){
        postsDAO.updatePost(post);
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        model.addAttribute("profile", profileDAO.viewThisProfileFromUserId(idUser));
        model.addAttribute("posts", postsDAO.retrievePostsByProfileId(idUser));
        model.addAttribute("editPost", new Posts());
        return "profilePage";
    }
}
