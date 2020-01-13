package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.FormUser;
import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.entity.health.calendar.UserToHcApp;
import com.CezaryZal.exceptions.NullInputException;
import com.CezaryZal.manager.filters.comparator.LoginNameComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormUserValidatorService {

    private LoginFormValidator loginFormValidator;
    private PasswordFormValidator passwordFormValidator;
    private EmailFormValidator emailFormValidator;
    private RoleValidator roleValidator;
    private LoginNameComparator loginNameComparator;

    @Autowired
    public FormUserValidatorService(LoginFormValidator loginFormValidator,
                                    PasswordFormValidator passwordFormValidator,
                                    EmailFormValidator emailFormValidator,
                                    RoleValidator roleValidator,
                                    LoginNameComparator loginNameComparator) {
        this.loginFormValidator = loginFormValidator;
        this.passwordFormValidator = passwordFormValidator;
        this.emailFormValidator = emailFormValidator;
        this.roleValidator = roleValidator;
        this.loginNameComparator = loginNameComparator;
    }

    public void handleAuthenticationRequest(AuthenticationRequest inputAuthenticationRequest) {
        validLoginAndPassword(inputAuthenticationRequest);
    }

    public void handleInputUser(UserToHcApp userToHcApp){
        validLoginAndPassword(userToHcApp);
        emailFormValidator.validEmail(userToHcApp.getEmail());
        roleValidator.validRole(userToHcApp.getRoles());
        loginNameComparator.throwIfInputLoginNameExists(userToHcApp.getLoginName());
    }

    private void validLoginAndPassword(FormUser formUser) {
        throwIfIsEmptyUserLogin(formUser);
        loginFormValidator.validLogin(formUser.getLoginName());
        passwordFormValidator.validPassword(formUser.getPassword());
    }

    private void throwIfIsEmptyUserLogin(FormUser formUser) {
        if (loginFormValidator.isNull(formUser)) {
            throw new NullInputException("User login is null");
        }
    }


}
