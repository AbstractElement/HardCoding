package com.application.validators;

import com.application.entity.User;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Vladislav on 01.09.2016.
 */

@Component
public class UserValidator implements Validator {
    @Override
    public void validate(Object user, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "message.error.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "message.error.password");

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }
}
