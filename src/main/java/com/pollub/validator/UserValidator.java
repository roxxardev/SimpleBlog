package com.pollub.validator;

import com.pollub.model.User;
import com.pollub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Eryk on 2017-04-13.
 */

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username", "Must not be empty");
        if(user.getUsername().length() < 6 || user.getUsername().length() > 24) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if(userService.findByUsername(user.getUsername())!=null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(user.getPassword().length() < 6 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if(!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
