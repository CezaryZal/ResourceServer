package com.CezaryZal.manager.modifier.entity;

import com.CezaryZal.entity.health.calendar.InputUser;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public UserAuthentication convertInputUserToUserAuth(InputUser inputUser) {
        UserAuthentication userAuth = new UserAuthentication();
        userAuth.setLoginName(inputUser.getLoginName());
        userAuth.setPassword(inputUser.getPassword());
        userAuth.setApproved(true);
        userAuth.setRoles(inputUser.getRoles());
        userAuth.setPermissions("NULL");
        return userAuth;
    }
}
