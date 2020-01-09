package com.CezaryZal.manager;

import com.CezaryZal.entity.health.calendar.ConnectingUser;
import com.CezaryZal.entity.health.calendar.InputUser;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.manager.connector.AccountCreator;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.AuthReqValidatorService;
import com.CezaryZal.manager.modifier.entity.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


@Service
public class LoginService {

    private UserHcAuthService userHCAuthService;
    private TokenBuilder tokenBuilder;
    private AuthReqValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;
    private AccountCreator accountCreator;
    private Converter converter;

    @Autowired
    public LoginService(UserHcAuthService userHCAuthService,
                        TokenBuilder tokenBuilder,
                        AuthReqValidatorService userLoginValidator,
                        PasswordComparator passwordComparator,
                        AccountCreator accountCreator,
                        Converter converter) {
        this.userHCAuthService = userHCAuthService;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
        this.accountCreator = accountCreator;
        this.converter = converter;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
        handleUserLogin(inputAuthenticationRequest);
        UserAuthentication foundUserAuthentication = userHCAuthService.findByLoginName(inputAuthenticationRequest.getLogin());
        throwExceptionIfUserIsNotActive(foundUserAuthentication);
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthenticationRequest.getPassword(), foundUserAuthentication.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserAuthentication);
    }

    public String creteNewAccount(InputUser inputUser){
        ConnectingUser connectingUser = new ConnectingUser(inputUser.getLoginName(), inputUser.getEmail());
        Long userIdFromHc = accountCreator.createAccountInHealthCalendarAndGetUserId(connectingUser);
        UserAuthentication userAuth = converter.convertInputUserToUserAuth(inputUser);
        userAuth.setUserId(userIdFromHc);
        userHCAuthService.addNewUser(userAuth);

        return "Został stworzony nowy użytkownik";
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
