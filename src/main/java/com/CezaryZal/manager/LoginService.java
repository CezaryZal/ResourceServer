package com.CezaryZal.manager;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import com.CezaryZal.manager.db.service.UserServiceImp;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.UserLoginValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import javax.security.auth.login.AccountNotFoundException;


@Service
public class LoginService {

    private UserServiceImp userServiceImp;
    private TokenBuilder tokenBuilder;
    private UserLoginValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserServiceImp userServiceImp, TokenBuilder tokenBuilder,
                        UserLoginValidatorService userLoginValidator, PasswordComparator passwordComparator) {
        this.userServiceImp = userServiceImp;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
    }

    public String getTokenByUserLogin(UserLogin inputUserLogin) throws NameNotFoundException, AccountNotFoundException {

            handleUserLogin(inputUserLogin);
            User foundUser = userServiceImp.findByLoginName(inputUserLogin.getLogin());
            handleUserByActive(foundUser);
            passwordComparator.throwIsNotEqualsPassword(inputUserLogin.getPassword(), foundUser.getPassword());

        return tokenBuilder.buildTokenByUser(foundUser);
    }

    private void handleUserLogin(UserLogin inputUserLogin) {
        userLoginValidator.isCorrectUserLogin(inputUserLogin);
    }

    private void handleUserByActive(User foundUser) throws AccountNotFoundException {
        if (!foundUser.isActive()) {
            throw new AccountNotFoundException("The requested user has not been activated");
        }
    }

}
