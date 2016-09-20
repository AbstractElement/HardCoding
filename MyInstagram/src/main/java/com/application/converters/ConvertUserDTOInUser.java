package com.application.converters;

import com.application.dto.UserDTO;
import com.application.entity.User;
import com.application.service.protect.ProtectedPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Vladislav on 10.09.2016.
 */

@Component
public class ConvertUserDTOInUser {
    @Autowired
    private ProtectedPassword protectedPassword;

    public User convertUserDTOInUser(User user, UserDTO userDTO){
        user.setEmail(userDTO.getEmail());
        user.setPass(protectedPassword.goProtected(userDTO.getPass()));
        return user;
    }
}
