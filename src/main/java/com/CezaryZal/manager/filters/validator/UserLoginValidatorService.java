package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.exceptions.IncorrectInput;
import org.springframework.stereotype.Service;

@Service
public class UserLoginValidatorService {

    private LoginFormValidator loginFormValidator;
    private PasswordFormValidator passwordFormValidator;

    public UserLoginValidatorService(LoginFormValidator loginFormValidator, PasswordFormValidator passwordFormValidator) {
        this.loginFormValidator = loginFormValidator;
        this.passwordFormValidator = passwordFormValidator;
    }

    public void isCorrectUserLogin(UserLogin userLogin) {
        try {
            throwIsEmptyUserLogin(userLogin);
            loginFormValidator.validLogin(userLogin.getLogin());
            passwordFormValidator.validPassword(userLogin.getPassword());
        } catch (RuntimeException exc){
            throw new IncorrectInput(exc.getMessage());
        }
    }

    private void throwIsEmptyUserLogin(UserLogin userLogin) {
        if (loginFormValidator.isEmpty(userLogin)) {
            throw new NullPointerException("User login is null");
        }
    }




}
