package com.CezaryZal.manager.modifier.entity;

import com.CezaryZal.entity.health.calendar.UserToHcApp;
import com.CezaryZal.entity.health.calendar.UserAuthentication;
import org.springframework.stereotype.Service;

@Service
public class ConverterEntity {

    public UserAuthentication convertInputUserToUserAuth(UserToHcApp userToHcApp) {
        UserAuthentication userAuth = new UserAuthentication();
        userAuth.setLoginName(userToHcApp.getLoginName());
        userAuth.setPassword(userToHcApp.getPassword());
        userAuth.setApproved(true);
        userAuth.setRoles(userToHcApp.getRoles());
        userAuth.setPermissions("NULL");
        return userAuth;
    }
}
