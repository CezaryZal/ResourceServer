package com.CezaryZal.entity.app;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthenticationRequest {

    private String login;
    private String password;

}
