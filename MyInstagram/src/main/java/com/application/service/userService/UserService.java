package com.application.service.userService;

import com.application.dto.UserDTO;
import com.application.entity.User;

/**
 * Created by Vladislav on 20.09.2016.
 */
public interface UserService {
    public User createUser(User addUser) throws Exception;
    public User retrieveUser(String email, String pass) throws Exception;
    public User convertUserDTOInUser(User user, UserDTO userDTO);
}
