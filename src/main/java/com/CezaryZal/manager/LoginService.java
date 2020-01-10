package com.CezaryZal.manager;

import com.CezaryZal.entity.health.calendar.ConnectingUser;
import com.CezaryZal.entity.health.calendar.InputUser;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.manager.connector.AccountCreator;
import com.CezaryZal.manager.creator.AuthRequestByUserConstant;
import com.CezaryZal.manager.creator.HttpEntityByBodyAndToken;
import com.CezaryZal.manager.creator.NewUser;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.FormUserValidatorService;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


@Service
public class LoginService {

    private UserHcAuthService userHCAuthService;
    private TokenBuilder tokenBuilder;
    private FormUserValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;
    private AccountCreator accountCreator;
    private AuthRequestByUserConstant authRequestByUserConstant;
    private HttpEntityByBodyAndToken httpEntityBodyToken;
    private NewUser newUser;

    public LoginService(UserHcAuthService userHCAuthService,
                        TokenBuilder tokenBuilder,
                        FormUserValidatorService userLoginValidator,
                        PasswordComparator passwordComparator,
                        AccountCreator accountCreator,
                        AuthRequestByUserConstant authRequestByUserConstant,
                        HttpEntityByBodyAndToken httpEntityBodyToken,
                        NewUser newUser) {
        this.userHCAuthService = userHCAuthService;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
        this.accountCreator = accountCreator;
        this.authRequestByUserConstant = authRequestByUserConstant;
        this.httpEntityBodyToken = httpEntityBodyToken;
        this.newUser = newUser;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
        userLoginValidator.handleAuthenticationRequest(inputAuthenticationRequest);
        UserAuthentication foundUserAuthentication = userHCAuthService.findByLoginName(inputAuthenticationRequest.getLoginName());
        throwExceptionIfUserIsNotActive(foundUserAuthentication);
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthenticationRequest.getPassword(), foundUserAuthentication.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserAuthentication);
    }

    public String creteNewAccount(InputUser inputUser) throws AccountNotFoundException {
        userLoginValidator.handleInputUser(inputUser);
        ConnectingUser connectingUser = new ConnectingUser(inputUser.getLoginName(), inputUser.getEmail());

        String clearToken = getTokenByUserLogin(authRequestByUserConstant.createAuthRequest());
        HttpEntity<Object> httpEntity = httpEntityBodyToken.createHttpEntity(connectingUser, clearToken);
        Long userIdFromHc = accountCreator.createAccountInHealthCalendarAndGetUserId(httpEntity);
        newUser.createNewUser(userIdFromHc, inputUser);

        return "Został stworzony nowy użytkownik";
    }

    private void throwExceptionIfUserIsNotActive(UserAuthentication foundUserAuthentication) throws AccountNotFoundException {
        if (!foundUserAuthentication.isApproved()) {
            throw new AccountNotFoundException("The requested user has not been activated");
        }
    }
}
