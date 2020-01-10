package com.CezaryZal.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserConstants {

    public static String LOGIN;
    public static String PASSWORD;

    public UserConstants() {
    }

    @Value("${token.create.authentication.request.login}")
    private void setLogin(String login) {
        this.LOGIN = login;
    }

    @Value("${token.create.authentication.request.password}")
    private void setPassword(String password) {
        this.PASSWORD = password;
    }
}
