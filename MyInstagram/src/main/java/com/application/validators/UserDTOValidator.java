package com.application.validators;

import com.application.dto.UserDTO;
import com.application.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Vladislav on 01.09.2016.
 */

@Component
public class UserDTOValidator implements Validator {
    @Autowired
    private UserUtils userUtils;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object userDTO, Errors errors) {
        UserDTO currentUser = (UserDTO) userDTO;
        try {
            if(!userUtils.thisUserIsExist(currentUser.getEmail()))
                errors.rejectValue("email", "message.error.wrongEmail");
            else if(!userUtils.thisTrueUserPassword(currentUser.getPass(), currentUser.getEmail()))
                errors.rejectValue("pass", "message.error.wrongPass");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void validateFromSignUp(Object userDTO, Errors errors) {
        UserDTO currentUser = (UserDTO) userDTO;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "message.error.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "message.error.password");
        try {
            if(!currentUser.getPass().equals(currentUser.getRepeatPassword()))
                errors.rejectValue("repeatPassword", "message.error.notEqualsPass");
            else if(userUtils.thisUserIsExist(currentUser.getEmail()))
                errors.rejectValue("email", "message.error.emailIsExist");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
