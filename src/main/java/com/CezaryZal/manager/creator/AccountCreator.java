package com.CezaryZal.manager.creator;

import com.CezaryZal.entity.app.AuthenticationRequest;
import com.CezaryZal.entity.health.calendar.UserToHcApp;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.manager.builder.TokenBuilder;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import com.CezaryZal.manager.modifier.entity.ConverterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class AccountCreator {

    private TokenBuilder tokenBuilder;
    private UserHcAuthService userHCAuthService;
    private ConverterEntity converterEntity;

    @Autowired
    public AccountCreator(TokenBuilder tokenBuilder, UserHcAuthService userHCAuthService, ConverterEntity converterEntity) {
        this.tokenBuilder = tokenBuilder;
        this.userHCAuthService = userHCAuthService;
        this.converterEntity = converterEntity;
    }

    public void createAccountByInputUser(UserToHcApp userToHcApp) throws AccountNotFoundException {
        String tokenByUserConstants = getTokenByUserConstants();
        Long userIdFromHc = UserInHcAppCreator.createAccountInHealthCalendarAndGetUserIdByInputUser(userToHcApp, tokenByUserConstants);
        createUserInThisApp(userToHcApp, userIdFromHc);
    }

    public String getTokenByUserConstants() throws AccountNotFoundException {
        AuthRequestByUserConstant authRequestByUserConstant = new AuthRequestByUserConstant();
        AuthenticationRequest authRequestTmp = authRequestByUserConstant.getAuthRequestByUserConstants();
        UserAuthentication foundUserAuthentication = userHCAuthService.findByLoginName(authRequestTmp.getLoginName());

        return tokenBuilder.buildTokenByUser(foundUserAuthentication);
    }

    private void createUserInThisApp(UserToHcApp userToHcApp, Long userIdFromHc) {
        UserAuthentication userAuth = converterEntity.convertInputUserToUserAuth(userToHcApp);
        userAuth.setUserId(userIdFromHc);
        userHCAuthService.addNewUser(userAuth);
    }
}
