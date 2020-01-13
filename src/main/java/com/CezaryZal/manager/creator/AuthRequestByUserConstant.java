package com.CezaryZal.manager.creator;

import com.CezaryZal.constants.UserConstants;
import com.CezaryZal.entity.app.AuthenticationRequest;

public class AuthRequestByUserConstant {

    private String login;
    private String password;

    public AuthRequestByUserConstant() {
        this.login = UserConstants.LOGIN;
        this.password = UserConstants.PASSWORD;
    }

    public AuthenticationRequest getAuthRequestByUserConstants(){
        return new AuthenticationRequest(login, password);
    }

}
