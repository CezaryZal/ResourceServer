package com.CezaryZal.manager;

import com.CezaryZal.entity.UserToHc;
import com.CezaryZal.entity.AuthenticationRequest;
import com.CezaryZal.manager.db.service.UserHcService;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.UserLoginValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


@Service
public class LoginService {

    private UserHcService userHCService;
    private TokenBuilder tokenBuilder;
    private UserLoginValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserHcService userHCService, TokenBuilder tokenBuilder,
                        UserLoginValidatorService userLoginValidator, PasswordComparator passwordComparator) {
        this.userHCService = userHCService;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
            handleUserLogin(inputAuthenticationRequest);
            UserToHc foundUserToHc = userHCService.findByLoginName(inputAuthenticationRequest.getLogin());
            throwExceptionIfUserIsNotActive(foundUserToHc);
            passwordComparator.throwIsNotEqualsPassword(inputAuthenticationRequest.getPassword(), foundUserToHc.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserToHc);
    }

    private void handleUserLogin(AuthenticationRequest inputAuthenticationRequest) {
        userLoginValidator.validUserLogin(inputAuthenticationRequest);
    }

    private void throwExceptionIfUserIsNotActive(UserToHc foundUserToHc) throws AccountNotFoundException {
        if (!foundUserToHc.isApproved()) {
            throw new AccountNotFoundException("The requested user has not been activated");
        }
    }
}
