package com.application.controllers;

import com.application.converters.ConvertUserDTOInUser;
import com.application.dao.PostsDAO;
import com.application.dao.ProfileDAO;
import com.application.entity.Profile;
import com.application.entity.User;
import com.application.dao.UserDAO;
import com.application.dto.UserDTO;
import com.application.utils.UserUtils;
import com.application.validators.UserDTOValidator;
import com.application.validators.UserValidator;
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
//	@Autowired
//	private UserValidator userValidator;
	@Autowired
	private UserDTOValidator userDTOValidator;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProfileDAO profileDAO;
	@Autowired
	private PostsDAO postsDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String toMainPage(ModelMap modelMap,
							 HttpSession session) {
		session.setAttribute("idUser", "");
		modelMap.addAttribute("userDTO", new UserDTO());
		return "mainPage";
	}

	@RequestMapping(method = RequestMethod.GET, value = "signup")
	public String toSignUp(ModelMap modelMap,
						   @ModelAttribute("userDTO") UserDTO userDTO) {
		modelMap.addAttribute("userDTO", userDTO);
		return "signUp";
	}

	@RequestMapping(value = "account/login", method = RequestMethod.POST)
	public String toMainPage(ModelMap modelMap,
							 HttpSession session,
							 @ModelAttribute(value = "userDTO")UserDTO userDTO,
							 BindingResult result) throws Exception {
		userDTOValidator.validate(userDTO, result);
		if(result.hasErrors()) {
			modelMap.addAttribute("userDTO", userDTO);
			return "mainPage";
		}
		else {
			User user = userDAO.retrieveUser(userDTO.getEmail(), userDTO.getPass());
			session.setAttribute("idUser", user.getId());
			modelMap.addAttribute("posts", postsDAO.retrievePostsByProfileId(user.getId()));
			modelMap.addAttribute("profile", profileDAO.viewThisProfileFromUserId(user.getId()));
			return "profilePage";
		}
	}

	@RequestMapping(value = "account/registration", method = RequestMethod.POST)
	public String saveSignUp(ModelMap modelMap,
							 @ModelAttribute(value = "userDTO")UserDTO userDTO,
							 BindingResult result) throws Exception {
		userDTOValidator.validateFromSignUp(userDTO, result);
		if (result.hasErrors()) {
			modelMap.addAttribute("userDTO", userDTO);
			return "signUp";
		}
		else {
			User addUser = ConvertUserDTOInUser.convertUserDTOInUser(new User(), userDTO);
			userDAO.createUser(addUser);
			profileDAO.createProfile(addUser, new Profile());
			return "successful";
		}
	}
}