package com.application.service.userService;

import com.application.dto.UserDTO;
import com.application.entity.User;

public interface UserService {
    public User createUser(User addUser) throws Exception;
    public User retrieveUser(String email, String pass) throws Exception;
    public User convertUserDTOInUser(User user, UserDTO userDTO);
}
