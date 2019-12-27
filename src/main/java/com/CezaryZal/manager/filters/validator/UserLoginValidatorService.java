package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.UserLogin;
import org.springframework.stereotype.Service;

@Service
public class UserLoginValidatorService {

    private LoginFormValidator loginFormValidator;
    private PasswordFormValidator passwordFormValidator;

    public UserLoginValidatorService(LoginFormValidator loginFormValidator, PasswordFormValidator passwordFormValidator) {
        this.loginFormValidator = loginFormValidator;
        this.passwordFormValidator = passwordFormValidator;
    }

    public boolean isCorrectUserLogin(UserLogin userLogin) {
        return isEmptyUserLogin(userLogin) ||
                loginFormValidator.validLogin(userLogin.getLogin()) ||
                passwordFormValidator.validPassword(userLogin.getPassword());
    }

    private boolean isEmptyUserLogin(UserLogin userLogin) {
        return loginFormValidator.isEmpty(userLogin);
    }




}
