package com.CezaryZal.manager.filters.comparator;

import com.CezaryZal.exceptions.LoginNameExistsException;
import com.CezaryZal.manager.health.calendar.service.UserHcAuthService;
import org.springframework.stereotype.Service;

@Service
public class LoginNameComparator {

    private UserHcAuthService userHcAuthService;

    public LoginNameComparator(UserHcAuthService userHcAuthService) {
        this.userHcAuthService = userHcAuthService;
    }

    public void throwIfInputLoginNameExists(String loginName){
        if (userHcAuthService.isExistsUserAuthenticationByLoginName(loginName)){
            throw new LoginNameExistsException("An account with this login name already exists");
        }
    }
}
