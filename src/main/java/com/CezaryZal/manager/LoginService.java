package com.CezaryZal.manager;

import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.AuthReqValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


@Service
public class LoginService {

    private UserHcAuthService userHCAuthService;
    private TokenBuilder tokenBuilder;
    private AuthReqValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;

    @Autowired
    public LoginService(UserHcAuthService userHCAuthService,
                        TokenBuilder tokenBuilder,
                        AuthReqValidatorService userLoginValidator,
                        PasswordComparator passwordComparator) {
        this.userHCAuthService = userHCAuthService;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
        handleUserLogin(inputAuthenticationRequest);
        UserAuthentication foundUserAuthentication = userHCAuthService.findByLoginName(inputAuthenticationRequest.getLogin());
        throwExceptionIfUserIsNotActive(foundUserAuthentication);
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthenticationRequest.getPassword(), foundUserAuthentication.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserAuthentication);
    }

    private void handleUserLogin(AuthenticationRequest inputAuthenticationRequest) {
        userLoginValidator.validUserLogin(inputAuthenticationRequest);
    }

    private void throwExceptionIfUserIsNotActive(UserAuthentication foundUserAuthentication) throws AccountNotFoundException {
        if (!foundUserAuthentication.isApproved()) {
            throw new AccountNotFoundException("The requested user has not been activated");
        }
    }
}
