package com.application.controllers;

import com.application.entity.Posts;
import com.application.entity.Profile;
import com.application.service.postsService.PostsService;
import com.application.service.profileService.ProfileService;
import com.application.validators.PostsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostsValidator postsValidator;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private PostsService postsService;

    /**
     *
     *  Функция, которая перенаправляет на страницу создания новой публикации.
     *
     * @param model - передает пустой объект публикации, для заполнения на странице
     * @return - возвращет на страницу созания новой пубикации
     */
    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public String toNewPost(Model model){
        model.addAttribute("post", new Posts());
        return "workWithPosts/addPost";
    }

    /**
     *
     *  Функция, которая добавляет новую публикацию в таблицу публикаций БД и, при корректном вводе,
     *  перенаправляет на страницу профиля.
     *  Перед добавление публикации в БД она проходит валидацию и при обнаружении ошибок возвращает на страницу
     *  создания новой публикации.
     *  В случае корректного ввода, новой публикации присваивается текущее время и номер текущего профиля.
     *
     * @param model - передает все публикации текущего пользователя и информацию о теекущем профиле
     * @param session - возвращает из сессии номер текущего пользователя
     * @param post - возвращает объект новой публикации, содержащий сообщение
     * @param result - возможные ошибки
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String saveNewPost(Model model,
                              HttpSession session,
                              @ModelAttribute("post") Posts post,
                              BindingResult result) throws Exception {
        postsValidator.validate(post, result);
        if (result.hasErrors()) {
            model.addAttribute("post", post);
            return "workWithPosts/addPost";
        }
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        Profile tableProfile = profileService.viewThisProfileFromUserId(idUser);
        post.setTimeOfPublication(new Date());
        post.setProfile(tableProfile);
        postsService.createPost(post);
        model.addAttribute("posts", postsService.retrievePostsByProfileId(idUser));
        model.addAttribute("profile", profileService.viewThisProfileFromUserId(idUser));
        return "workWithProfile/profilePage";
    }

    /**
     *
     *  Функция удаления публикации. Перенаправляет на страницу профиля.
     *
     * @param model - передает информацию о профиле и все его публикации
     * @param session - возвращает из сессии номер текущего пользователя
     * @param idPost - возвращает со страницы номер публикации, которую необходимо удалить
     * @return - возвращает обратно на страницу профиля
     * @throws Exception
     */
    @RequestMapping(value = "/delete/{idPost}", method = RequestMethod.GET)
    public String deletePost(Model model,
                             HttpSession session,
                             @PathVariable int idPost) throws Exception {
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        postsService.deletePost(idPost);
        model.addAttribute("profile", profileService.viewThisProfileFromUserId(idUser));
        model.addAttribute("posts", postsService.retrievePostsByProfileId(idUser));
        return "workWithProfile/profilePage";
    }

    /**
     *
     *  Функция редактирования публикации. Публикация помечается как "готовая к изменениям"
     *
     * @param model - передает отредактированную публикацию, все публикации и информацию о профиле
     * @param session - возвращает из сессии номер текущего пользователя
     * @param idPost - возвращает со страницы номер публикации, которую необходимо отредактировать
     * @return - возвращает страницу профиля
     * @throws Exception
     */
    @RequestMapping(value = "/edit/{idPost}", method = RequestMethod.GET)
    public String editPost(Model model,
                           HttpSession session,
                           @PathVariable String idPost) throws Exception {
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        Posts post = postsService.retrievePostById(idPost);
        model.addAttribute("editPost", post);
        model.addAttribute("posts", postsService.retrievePostsByProfileId(idUser));
        model.addAttribute("profile", profileService.viewThisProfileFromUserId(idUser));
        return "workWithProfile/profilePage";
    }

    /**
     *
     *  Функция, которая сохраняет отредактированную публикацию.
     *
     * @param model - передает информацию о профиле, все публикации пользователя
     * @param session - возвращает из сессии номер текущего пользователя
     * @param post - получает объект публикации, который необходимо обновить в таблице БД
     * @return - возвращает на страницу профиля
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditPost(Model model,
                               HttpSession session,
                               @ModelAttribute("editPost") Posts post){
        postsService.updatePost(post);
        int idUser = Integer.parseInt(session.getAttribute("idUser").toString());
        model.addAttribute("profile", profileService.viewThisProfileFromUserId(idUser));
        model.addAttribute("posts", postsService.retrievePostsByProfileId(idUser));
        model.addAttribute("editPost", new Posts());
        return "workWithProfile/profilePage";
    }
}
