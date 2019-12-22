package com.CezaryZal.manager.filters;

import com.CezaryZal.entity.UserLogin;
import org.springframework.stereotype.Component;


@Component
public class ParseInput {

    public boolean isEmpty(UserLogin userLogin){
        return userLogin == null ||
                userLogin.getLogin() == null ||
//                userLogin.getLogin().equals("") ||
                userLogin.getPassword() == null ||
                userLogin.getPassword().equalsIgnoreCase("");
    }

    public boolean areToShortInputsUserLogin(UserLogin userLogin){
        return  isToShortLogin(userLogin.getLogin()) || isToShortPassword(userLogin.getPassword());
    }

    private boolean isToShortLogin(String login){
        return login.length()<4;
    }

    private boolean isToShortPassword(String password){
        return password.length()<4;
    }
}
