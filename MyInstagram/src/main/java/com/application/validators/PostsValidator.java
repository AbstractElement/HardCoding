package com.application.validators;

import com.application.entity.Posts;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PostsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Posts.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Posts post = (Posts) o;
//        if(post.getProfile().getFirstName() == null || post.getProfile().getLastName() == null)
//            errors.rejectValue("message", "message.error.emptyName");
        if (post.getMessage().equals(""))
            errors.rejectValue("message", "message.error.emptyMessage");
        if (post.getMessage().length() > 200)
            errors.rejectValue("message", "message.error.overflowMessage");
    }
}
