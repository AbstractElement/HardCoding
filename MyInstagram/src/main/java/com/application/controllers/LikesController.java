package com.application.controllers;

import com.application.dao.UserDAO;
import com.application.dao.impl.LikesDAOImpl;
import com.application.dao.impl.UserDAOImpl;
import com.application.entity.Likes;
import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.service.likeService.LikeService;
import com.application.service.postsService.PostsService;
import com.application.service.profileService.ProfileService;
import com.application.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/likes/")
public class LikesController {
    @Autowired
    private ProfileService profileService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private PostsService postsService;

    @RequestMapping(value = "/addLike/{idPost}/{idProfile}", method = RequestMethod.GET)
    public String addLikes(Model model,
                           HttpSession session,
                           @PathVariable("idPost")int idPost,
                           @PathVariable("idProfile")int idProfile) throws Exception {
        Posts post = postsService.retrievePostById(String.valueOf(idPost));
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        Profile profile = profileService.retrieveProfile(idProfile);
        List<Posts> posts = postsService.retrievePostsByProfileId(idProfile);
        Likes newLike = new Likes();
        newLike.setIdPosts(post);
        newLike.setOwnerLike(profileService.viewThisProfileFromUserId(idUser));
        likeService.createLike(newLike);
        model.addAttribute("profile", profile);
        model.addAttribute("posts", posts);
        return "workWithProfile/profilePage";
    }

}
