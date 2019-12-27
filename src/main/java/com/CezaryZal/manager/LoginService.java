package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.db.service.UserServiceImp;
import com.CezaryZal.manager.filters.FormValidator;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.Validator;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private UserServiceImp userServiceImp;
    private Validator validator;
    private TokenBuilder tokenBuilder;
    private FormValidator formValidator;

    private User foundUser;

    public LoginService(UserServiceImp userServiceImp, Validator validator, TokenBuilder tokenBuilder, FormValidator formValidator) {
        this.userServiceImp = userServiceImp;
        this.validator = validator;
        this.tokenBuilder = tokenBuilder;
        this.formValidator = formValidator;
    }

    public String getTokenByUserLogin(UserLogin inputUserLogin) {
        handleInputUserLoginIfEmpty(inputUserLogin);
        foundUser = userServiceImp.findByLoginName(inputUserLogin.getLogin());
        handleUserByActive();
        validInputUserLogin(inputUserLogin);
        return tokenBuilder.buildTokenByUser(foundUser);
    }

    private void handleInputUserLoginIfEmpty(UserLogin inputUserLogin){
        if (formValidator.isEmpty(inputUserLogin)) {
            throw new RuntimeException("Przesłany formularz jest pusty");
        } else if (formValidator.areToShortInputsUserLogin(inputUserLogin)){
            throw new RuntimeException("Przesłane dane użytkownika są zakrótkie");
        }
    }

    private void handleUserByActive() {
        if (!foundUser.isActive()) {
            throw new RuntimeException("Poszukiwany użytkownik nie został jeszcze aktywowany");
        }
    }

    private void validInputUserLogin(UserLogin inputUserLogin) {
        validator.setFoundUser(foundUser);
        if (!validator.validInputLogin(inputUserLogin)) {
            throw new RuntimeException("Błedne hasło użytkownika");
        }
    }

}
