package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.exceptions.IncorrectInputException;
import com.CezaryZal.exceptions.NullInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginValidatorService {

    private LoginFormValidator loginFormValidator;
    private PasswordFormValidator passwordFormValidator;

    @Autowired
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
            throw new IncorrectInputException(exc.getMessage());
        }
    }

    private void throwIsEmptyUserLogin(UserLogin userLogin) {
        if (loginFormValidator.isEmpty(userLogin)) {
            throw new NullInputException("User login is null");
        }
    }
}
