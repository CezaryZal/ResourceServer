package com.CezaryZal.entity.app;

import com.CezaryZal.entity.FormUser;

public class AuthenticationRequest extends FormUser {

    public AuthenticationRequest(String loginName, String password) {
        super(loginName, password);
    }

    @Override
    public String getLoginName() {
        return super.getLoginName();
    }

    @Override
    public String getRoles() {
        return super.getRoles();
    }

}
