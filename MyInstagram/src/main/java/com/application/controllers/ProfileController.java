package com.application.controllers;

import com.application.dao.PostsDAO;
import com.application.dao.ProfileDAO;
import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.utils.ProfileUtils;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Vladislav on 05.09.2016.
 */

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileDAO profileDAO;

    @Autowired
    private PostsDAO postsDAO;

    @Autowired
    private ProfileUtils profileUtils;

    @RequestMapping(value = "posts", method = RequestMethod.GET)
    public String toProfilePosts(ModelMap modelMap,
                                HttpSession session) throws Exception {
        int index = Integer.parseInt(session.getAttribute("idUser").toString());
        modelMap.addAttribute("posts", postsDAO.retrievePosts());
        return "pagePosts";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String toEdit(Model model,
                         HttpSession session,
                         @ModelAttribute("editProfile")Profile profile){
        model.addAttribute("editProfile", profileDAO.viewThisProfileFromUserId
                (Integer.parseInt(session.getAttribute("idUser").toString())));
        return "editProfile";
    }

    @RequestMapping(value = "saveEdit",method = RequestMethod.POST)
    public String saveEdit(Model model,
                           HttpSession session,
                           @ModelAttribute("editProfile")Profile profile) throws Exception {
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        profileDAO.updateProfile(profile, idUser);
        model.addAttribute("profile", profileDAO.viewThisProfileFromUserId(idUser));
        model.addAttribute("posts", postsDAO.retrievePostsByProfileId(idUser));
        return "profilePage";
    }

    @RequestMapping(value = "people", method = RequestMethod.GET)
    public String showPeople(Model model){
        List<Profile> profileList = profileUtils.viewAllProfiles();
        model.addAttribute("profileList", profileList);
        return "allPeople";
    }

    @RequestMapping(value = "viewProfile/{idProfile}", method = RequestMethod.GET)
    public String viewProfilePage(Model model,
                                  @PathVariable("idProfile") int idProfile){
        Profile profile = profileDAO.viewThisProfileFromUserId(idProfile);
        List<Posts> posts = postsDAO.retrievePostsByProfileId(idProfile);
        model.addAttribute("profile", profile);
        model.addAttribute("posts", posts);
        return "profilePage";
    }
}
