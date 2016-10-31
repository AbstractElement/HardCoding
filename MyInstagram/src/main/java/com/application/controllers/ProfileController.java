package com.application.controllers;

import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.service.likeService.LikeService;
import com.application.service.postsService.PostsService;
import com.application.service.profileService.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
     *  Функция, которая перенаправляет на страницу всех публикаций
     *
     * @param modelMap - передает коллекцию всех публикаций
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
     * Получает информацию о пользователе и передает ее клиенту, перенаправляет на страницу регистрации
     *
     * @param model - передает информацию о пользователе
     * @param session - возвращает из сессии номер текущего пользователя
     * @param profile - возвращает информацию о профиле пользователя
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String toEdit(Model model,
                         HttpSession session,
                         @ModelAttribute("editProfile")Profile profile){
        int userId = Integer.parseInt(session.getAttribute("idUser").toString());
        Profile profile1 = profileService.viewThisProfileFromUserId(userId);
        model.addAttribute("editProfile", profile1);
        return "workWithProfile/editProfile";
    }

    /**
     *
     * Обновляет данные в таблице БД
     *
     * @param model - передает информацию о пользователе и его публикациях
     * @param session - возвращает из сессии номер текуего пользователя
     * @param profile - объет хранящий информацию о пользователе
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
     * Отображает всех зарегистрированных пользователей
     *
     * @param model - передает в модель коллекцию, состоящую из зарегистрированных профилей
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
     * Отображает страницу выбранного профиля.
     *
     * @param model - передает информацию выбранного профиля и его публикации на страницу клиента
     * @param idProfile - номер выбранного пользователя
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
     * Возвращает на текущего пользователя.
     *
     * @param model - передает информацию о текущем пользователе и его публикациях
     * @param session - возвращает из сессии номер текущего пользователя
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
