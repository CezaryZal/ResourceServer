package com.CezaryZal.manager.creator;

import com.CezaryZal.entity.health.calendar.InputUser;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import com.CezaryZal.manager.modifier.entity.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewUser {

    private Converter converter;
    private UserHcAuthService userHCAuthService;

    @Autowired
    public NewUser(Converter converter, UserHcAuthService userHCAuthService) {
        this.converter = converter;
        this.userHCAuthService = userHCAuthService;
    }

    public void createNewUser(Long userIdFromHc, InputUser inputUser){
        UserAuthentication userAuth = converter.convertInputUserToUserAuth(inputUser);
        userAuth.setUserId(userIdFromHc);
        userHCAuthService.addNewUser(userAuth);
    }
}
