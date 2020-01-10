package com.CezaryZal.manager.creator;

import com.CezaryZal.constants.UserConstants;
import com.CezaryZal.entity.app.AuthenticationRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthRequestByUserConstant {

    public AuthenticationRequest createAuthRequest(){
        return new AuthenticationRequest(UserConstants.LOGIN, UserConstants.PASSWORD);
    }
}
