package com.CezaryZal.manager;

import com.CezaryZal.entity.UserToDb;
import com.CezaryZal.entity.AuthenticationRequest;
import com.CezaryZal.manager.db.service.UserServiceImp;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.UserLoginValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String getTokenByUserLogin(AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
            handleUserLogin(inputAuthenticationRequest);
            UserToDb foundUserToDb = userServiceImp.findByLoginName(inputAuthenticationRequest.getLogin());
            throwExceptionIfUserIsNotActive(foundUserToDb);
            passwordComparator.throwIsNotEqualsPassword(inputAuthenticationRequest.getPassword(), foundUserToDb.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserToDb);
    }

    private void handleUserLogin(AuthenticationRequest inputAuthenticationRequest) {
        userLoginValidator.validUserLogin(inputAuthenticationRequest);
    }

    private void throwExceptionIfUserIsNotActive(UserToDb foundUserToDb) throws AccountNotFoundException {
        if (!foundUserToDb.isApproved()) {
            throw new AccountNotFoundException("The requested user has not been activated");
        }
    }
}
