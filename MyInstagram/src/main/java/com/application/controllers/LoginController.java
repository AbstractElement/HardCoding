package com.application.controllers;

import com.application.entity.Profile;
import com.application.entity.User;
import com.application.dto.UserDTO;
import com.application.service.postsService.PostsService;
import com.application.service.profileService.ProfileService;
import com.application.service.userService.UserService;
import com.application.validators.UserDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
	@Autowired
	private UserDTOValidator userDTOValidator;
	@Autowired
	private UserService userService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private PostsService postsService;

	/**
	 *
	 * Функция первоначального запуска приложения, которая перенаправляет на страницу авторизации.
	 *
	 * @param modelMap - передает пустой объект пользователя для авторизации
	 * @param session - обнуляет текущую сессию
	 * @return - возвращает на страницу авторизации
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String toMainPage(ModelMap modelMap,
							 HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("userDTO", new UserDTO());
		return "login/mainPage";
	}

	/**
	 *
	 * Фукнция, которая отвечает за перенапраление пользователя на страницу регистрации.
	 *
	 * @param modelMap - передает объект пользователя для записи в него данных регистрируемого
	 * @param userDTO - получаем объект со страницы авторизации
	 * @return - возвращает страницу регистрации
	 */
	@RequestMapping(method = RequestMethod.GET, value = "signup")
	public String toSignUp(ModelMap modelMap,
						   @ModelAttribute("userDTO") UserDTO userDTO) {
		modelMap.addAttribute("userDTO", userDTO);
		return "registration/signUp";
	}

	/**
	 *
	 *  Функция, которая перенаправляет на страницу авторизированного профиля.
	 *  Перед тем как перенаправить, совершается валидация профиля, в случае обнаружения ошибок возвращается страница
	 *  авторизации, иначе добавляем в сессию номер текущего пользователя.
	 *
	 * @param modelMap - передает все публикации и информацию текущего пользователя
	 * @param session - добавление в сессию номера текщего пользователя
	 * @param userDTO - полученный объект пользователя, необходим для валидации
	 * @param result - возможные ошибки
	 * @return - возврат на страницу авторизации или страницу профиля
	 * @throws Exception
	 */
	@RequestMapping(value = "account/login", method = RequestMethod.POST)
	public String toMainPage(ModelMap modelMap,
							 HttpSession session,
							 @ModelAttribute(value = "userDTO")UserDTO userDTO,
							 BindingResult result) throws Exception {
		userDTOValidator.validate(userDTO, result);
		if(result.hasErrors()) {
			modelMap.addAttribute("userDTO", userDTO);
			return "login/mainPage";
		}
		else {
			User user = userService.retrieveUser(userDTO.getEmail(), userDTO.getPass());
			session.setAttribute("idUser", user.getId());
			modelMap.addAttribute("posts", postsService.retrievePostsByProfileId(user.getId()));
			modelMap.addAttribute("profile", profileService.viewThisProfileFromUserId(user.getId()));
			return "workWithProfile/profilePage";
		}
	}

	/**
	 *
	 *  Функция, которая перенаправляет на страницу оповещения об успешной регистрации.
	 *  Добавляет объект нового пользователя в таблицу пользователей БД и пустой профиль в таблицу профилей БД.
	 *  Перед добавление объект проходит проверку на корректность введенных данных, в случае, если присутствует ошибка
	 *  функция возвращает на страницу регистрации.
	 *
	 * @param modelMap - передает в случае ошибки объект пользователя обратно на страницу регистрации
	 * @param userDTO - объект пользователя, полученный со страницы регистрации
	 * @param result - возможные ошибки
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "account/registration", method = RequestMethod.POST)
	public String saveSignUp(ModelMap modelMap,
							 @ModelAttribute(value = "userDTO")UserDTO userDTO,
							 BindingResult result) throws Exception {
		userDTOValidator.validateFromSignUp(userDTO, result);
		if (result.hasErrors()) {
			modelMap.addAttribute("userDTO", userDTO);
			return "registration/signUp";
		}
		else {
			User addUser = userService.convertUserDTOInUser(new User(), userDTO);
			userService.createUser(addUser);
			profileService.createProfile(addUser, new Profile());
			return "registration/successful";
		}
	}
}