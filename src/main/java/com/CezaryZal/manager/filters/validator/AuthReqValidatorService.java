package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.FormUser;
import com.CezaryZal.exceptions.NullInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthReqValidatorService {

    private LoginFormValidator loginFormValidator;
    private PasswordFormValidator passwordFormValidator;

    @Autowired
    public AuthReqValidatorService(LoginFormValidator loginFormValidator, PasswordFormValidator passwordFormValidator) {
        this.loginFormValidator = loginFormValidator;
        this.passwordFormValidator = passwordFormValidator;
    }

    public void validUserLogin(FormUser formUser) {
            throwIfIsEmptyUserLogin(formUser);
            loginFormValidator.validLogin(formUser.getLoginName());
            passwordFormValidator.validPassword(formUser.getPassword());
    }

        private void throwIfIsEmptyUserLogin(FormUser formUser){
            if (loginFormValidator.isEmpty(formUser)) {
                throw new NullInputException("User login is null");
            }
        }
    }
