package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.app.AuthenticationRequest;
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

    public void validUserLogin(AuthenticationRequest authenticationRequest) {
            throwIfIsEmptyUserLogin(authenticationRequest);
            loginFormValidator.validLogin(authenticationRequest.getLogin());
            passwordFormValidator.validPassword(authenticationRequest.getPassword());
    }

        private void throwIfIsEmptyUserLogin(AuthenticationRequest authenticationRequest){
            if (loginFormValidator.isEmpty(authenticationRequest)) {
                throw new NullInputException("User login is null");
            }
        }
    }
