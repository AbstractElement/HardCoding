package com.application.controllers;

import com.application.dao.PostsDAO;
import com.application.dao.ProfileDAO;
import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.service.profileService.ProfileService;
import com.application.utils.ProfileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Vladislav on 05.09.2016.
 */

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private PostsDAO postsDAO;

    @Autowired
    private ProfileService profileService;

    @RequestMapping(value = "posts", method = RequestMethod.GET)
    public String toProfilePosts(ModelMap modelMap) throws Exception {
        modelMap.addAttribute("posts", postsDAO.retrievePosts());
        return "workWithPosts/pagePosts";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String toEdit(Model model,
                         HttpSession session,
                         @ModelAttribute("editProfile")Profile profile){
        model.addAttribute("editProfile", profileService.viewThisProfileFromUserId
                (Integer.parseInt(session.getAttribute("idUser").toString())));
        return "workWithProfile/editProfile";
    }

    @RequestMapping(value = "saveEdit",method = RequestMethod.POST)
    public String saveEdit(Model model,
                           HttpSession session,
                           @ModelAttribute("editProfile")Profile profile) throws Exception {
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        profileService.updateProfile(profile, idUser);
        model.addAttribute("profile", profileService.viewThisProfileFromUserId(idUser));
        model.addAttribute("posts", postsDAO.retrievePostsByProfileId(idUser));
        return "workWithProfile/profilePage";
    }

    @RequestMapping(value = "people", method = RequestMethod.GET)
    public String showPeople(Model model){
        List<Profile> profileList = profileService.viewAllProfiles();
        model.addAttribute("profileList", profileList);
        return "workWithProfile/allPeople";
    }

    @RequestMapping(value = "viewProfile/{idProfile}", method = RequestMethod.GET)
    public String viewProfilePage(Model model,
                                  @PathVariable("idProfile") int idProfile){
        Profile profile = profileService.viewThisProfileFromUserId(idProfile);
        List<Posts> posts = postsDAO.retrievePostsByProfileId(idProfile);
        model.addAttribute("profile", profile);
        model.addAttribute("posts", posts);
        return "workWithProfile/profilePage";
    }
}
