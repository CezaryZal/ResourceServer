package com.CezaryZal.entity.health.calendar;

public class ConnectingUser {

    public ConnectingUser(String loginName, String email) {
        this.loginName = loginName;
        this.email = email;
    }

    private String loginName;
    private String email;

    public String getLoginName() {
        return loginName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserCreator{" +
                "loginName='" + loginName + '\'' +
                "email='" + email + '\'' +
                '}';
    }
}
