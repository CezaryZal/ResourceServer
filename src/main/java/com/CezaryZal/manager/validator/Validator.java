package com.CezaryZal.manager.validator;

import com.CezaryZal.entity.User;
import com.CezaryZal.entity.UserLogin;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    private User foundUser;

    public void setFoundUser(User foundUser) {
        this.foundUser = foundUser;
    }

    public boolean validInputLogin(UserLogin userLogin){
        return foundUser.getPassword().equals(userLogin.getPassword());
    }

}
