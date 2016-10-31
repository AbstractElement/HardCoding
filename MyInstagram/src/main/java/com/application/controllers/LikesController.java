package com.application.controllers;

import com.application.entity.Likes;
import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.service.likeService.LikeService;
import com.application.service.postsService.PostsService;
import com.application.service.profileService.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
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

    /**
     *
     * Функция добавления и отображения лайка текущего пользователя.
     * Получает со страницы jsp номер публикации и номер профиля, который поставил лайк.
     * После создания объекта нового лайка идет проверка на возможное присутствие данного лайка в БД.
     * Если условие оказывается верным, лайк удаляется из БД, иначе объект хранящий новый лайк записывается в БД.
     *
     * @param model - запись в атрибут "prifile" объект профиля и запись в атрибут "posts" объект публикаций,
     *              хранящий все публикации профиля, под профилем понимается (на чьей странице находимся)
     * @param session - необходима для получения номера текущего авторизированного пользователя
     * @param idPost - возвращает номер понравившейся публикации
     * @return - возвращает страницу профиля
     * @throws Exception
     */
    @RequestMapping(value = "/addLike/{idPost}", method = RequestMethod.GET)
    public String addLikes(Model model,
                           HttpSession session,
                           @PathVariable("idPost")int idPost) throws Exception {
        Posts post = postsService.retrievePostById(String.valueOf(idPost));
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        Profile profile = profileService.retrieveProfile(post.getProfile().getIdProfile());
        List<Posts> posts = postsService.retrievePostsByProfileId(post.getProfile().getIdProfile());
        Likes newLike = new Likes();
        newLike.setIdPosts(post);
        newLike.setOwnerLike(profileService.viewThisProfileFromUserId(idUser));
        newLike.setTimeThisLike(new Date());
        if (likeService.thisLikeIsExist(newLike))
            likeService.deleteLike(newLike);
        else
            likeService.createLike(newLike);
        model.addAttribute("profile", profile);
        model.addAttribute("posts", posts);
        return "workWithProfile/profilePage";
    }

}
