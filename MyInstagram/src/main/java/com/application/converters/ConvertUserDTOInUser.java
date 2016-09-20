package com.application.converters;

import com.application.dto.UserDTO;
import com.application.entity.User;
import com.application.service.ProtectedPassword;

/**
 * Created by Vladislav on 10.09.2016.
 */
public class ConvertUserDTOInUser {
    public static User convertUserDTOInUser(User user, UserDTO userDTO){
        user.setEmail(userDTO.getEmail());
        user.setPass(userDTO.getPass());
        return user;
    }
}
