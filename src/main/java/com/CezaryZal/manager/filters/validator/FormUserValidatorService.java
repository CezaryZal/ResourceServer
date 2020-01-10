package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.FormUser;
import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.entity.health.calendar.InputUser;
import com.CezaryZal.exceptions.NullInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormUserValidatorService {

    private LoginFormValidator loginFormValidator;
    private PasswordFormValidator passwordFormValidator;
    private EmailFormValidator emailFormValidator;

    @Autowired
    public FormUserValidatorService(LoginFormValidator loginFormValidator, PasswordFormValidator passwordFormValidator, EmailFormValidator emailFormValidator) {
        this.loginFormValidator = loginFormValidator;
        this.passwordFormValidator = passwordFormValidator;
        this.emailFormValidator = emailFormValidator;
    }

    public void handleAuthenticationRequest(AuthenticationRequest inputAuthenticationRequest) {
        validLoginAndPassword(inputAuthenticationRequest);
    }

    public void handleInputUser(InputUser inputUser){
        validLoginAndPassword(inputUser);
        emailFormValidator.validEmail(inputUser.getEmail());
    }

    private void validLoginAndPassword(FormUser formUser) {
        throwIfIsEmptyUserLogin(formUser);
        loginFormValidator.validLogin(formUser.getLoginName());
        passwordFormValidator.validPassword(formUser.getPassword());
    }

    private void throwIfIsEmptyUserLogin(FormUser formUser) {
        if (loginFormValidator.isEmpty(formUser)) {
            throw new NullInputException("User login is null");
        }
    }


}
