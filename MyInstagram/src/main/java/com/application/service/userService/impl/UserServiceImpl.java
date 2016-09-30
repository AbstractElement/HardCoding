package com.application.service.userService.impl;

import com.application.converters.ConvertUserDTOInUser;
import com.application.dao.UserDAO;
import com.application.dto.UserDTO;
import com.application.entity.User;
import com.application.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ConvertUserDTOInUser convertUserDTOInUser;

    @Override
    public User createUser(User addUser) throws Exception {
        return userDAO.createUser(addUser);
    }

    @Override
    public User retrieveUser(String email, String pass) throws Exception {
        return userDAO.retrieveUser(email, pass);
    }

    @Override
    public User convertUserDTOInUser(User user, UserDTO userDTO) {
        return convertUserDTOInUser.convertUserDTOInUser(user, userDTO);
    }
}
