package com.CezaryZal.manager;

import com.CezaryZal.entity.health.calendar.UserToHcApp;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.manager.creator.AccountCreator;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.filters.comparator.PasswordComparator;
import com.CezaryZal.manager.filters.validator.FormUserValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;


@Service
public class LoginService {

    private UserHcAuthService userHCAuthService;
    private TokenBuilder tokenBuilder;
    private FormUserValidatorService userLoginValidator;
    private PasswordComparator passwordComparator;
    private AccountCreator accountCreator;

    @Autowired
    public LoginService(UserHcAuthService userHCAuthService,
                        TokenBuilder tokenBuilder,
                        FormUserValidatorService userLoginValidator,
                        PasswordComparator passwordComparator,
                        AccountCreator accountCreator) {
        this.userHCAuthService = userHCAuthService;
        this.tokenBuilder = tokenBuilder;
        this.userLoginValidator = userLoginValidator;
        this.passwordComparator = passwordComparator;
        this.accountCreator = accountCreator;
    }

    public String getTokenByUserLogin(AuthenticationRequest inputAuthenticationRequest) throws AccountNotFoundException {
        userLoginValidator.handleAuthenticationRequest(inputAuthenticationRequest);
        UserAuthentication foundUserAuthentication = userHCAuthService.findByLoginName(inputAuthenticationRequest.getLoginName());
        throwExceptionIfUserIsNotActive(foundUserAuthentication);
        passwordComparator.throwIfIsNotEqualsPassword(inputAuthenticationRequest.getPassword(), foundUserAuthentication.getPassword());

        return tokenBuilder.buildTokenByUser(foundUserAuthentication);
    }

    public String creteNewAccount(UserToHcApp userToHcApp) throws AccountNotFoundException {
        userLoginValidator.handleInputUser(userToHcApp);
        accountCreator.createAccountByInputUser(userToHcApp);

        return "Został stworzony nowy użytkownik";
    }

    private void throwExceptionIfUserIsNotActive(UserAuthentication foundUserAuthentication) throws AccountNotFoundException {
        if (!foundUserAuthentication.isApproved()) {
            throw new AccountNotFoundException("The requested user has not been activated");
        }
    }
}
