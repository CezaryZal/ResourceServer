package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.db.service.UserServiceImp;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.UserLoginValidatorService;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    private UserServiceImp userServiceImp;
    private TokenBuilder tokenBuilder;
    private UserLoginValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;

    public LoginService(UserServiceImp userServiceImp, TokenBuilder tokenBuilder,
                        UserLoginValidatorService userLoginValidator, PasswordComparator passwordComparator) {
        this.userServiceImp = userServiceImp;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
    }

    public String getTokenByUserLogin(UserLogin inputUserLogin) {
        handleUserLogin(inputUserLogin);
        User foundUser = userServiceImp.findByLoginName(inputUserLogin.getLogin());
        handleUserByActive(foundUser);
        passwordComparator.isEqualsPassword(inputUserLogin.getPassword(), foundUser.getPassword());
        return tokenBuilder.buildTokenByUser(foundUser);
    }

    private void handleUserLogin(UserLogin inputUserLogin){
        if (userLoginValidator.isCorrectUserLogin(inputUserLogin)){
            throw new RuntimeException("Zostały wpisane niewłaściwe dane");
        }
    }

    private void handleUserByActive(User foundUser) {
        if (!foundUser.isActive()) {
            throw new RuntimeException("Poszukiwany użytkownik nie został jeszcze aktywowany");
        }
    }

}
