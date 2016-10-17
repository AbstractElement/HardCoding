package com.application.controllers;

import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.service.postsService.PostsService;
import com.application.service.profileService.ProfileService;
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

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private PostsService postsService;
    @Autowired
    private ProfileService profileService;

    /**
     *
     * @param modelMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "posts", method = RequestMethod.GET)
    public String toProfilePosts(ModelMap modelMap) throws Exception {
        modelMap.addAttribute("posts", postsService.retrievePosts());
        return "workWithPosts/pagePosts";
    }

    /**
     *
     * @param model
     * @param session
     * @param profile
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String toEdit(Model model,
                         HttpSession session,
                         @ModelAttribute("editProfile")Profile profile){
        Profile profile1 = profileService.viewThisProfileFromUserId(Integer.parseInt(session.getAttribute("idUser").toString()));
        model.addAttribute("editProfile", profile1);
        return "workWithProfile/editProfile";
    }

    /**
     *
     * @param model
     * @param session
     * @param profile
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveEdit",method = RequestMethod.POST)
    public String saveEdit(Model model,
                           HttpSession session,
                           @ModelAttribute("editProfile")Profile profile) throws Exception {
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        profileService.updateProfile(profile, idUser);
        model.addAttribute("profile", profileService.viewThisProfileFromUserId(idUser));
        model.addAttribute("posts", postsService.retrievePostsByProfileId(idUser));
        return "workWithProfile/profilePage";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "people", method = RequestMethod.GET)
    public String showPeople(Model model){
        List<Profile> profileList = profileService.viewAllProfiles();
        model.addAttribute("profileList", profileList);
        return "workWithProfile/allPeople";
    }

    /**
     *
     * @param model
     * @param idProfile
     * @return
     */
    @RequestMapping(value = "viewProfile/{idProfile}", method = RequestMethod.GET)
    public String viewProfilePage(Model model,
                                  @PathVariable("idProfile") int idProfile){
        Profile profile = profileService.viewThisProfileFromUserId(idProfile);
        List<Posts> posts = postsService.retrievePostsByProfileId(idProfile);
        model.addAttribute("profile", profile);
        model.addAttribute("posts", posts);
        return "workWithProfile/profilePage";
    }

    /**
     *
     * @param model
     * @param session
     * @return
     */
    @RequestMapping(value = "myPage", method = RequestMethod.GET)
    public String toMyPage(Model model,
                           HttpSession session){
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        Profile myProfile = profileService.viewThisProfileFromUserId(idUser);
        model.addAttribute("profile", myProfile);
        model.addAttribute("posts", postsService.retrievePostsByProfileId(myProfile.getIdProfile()));
        return "workWithProfile/profilePage";
    }
}
