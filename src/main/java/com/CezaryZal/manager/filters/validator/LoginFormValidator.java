package com.CezaryZal.manager.filters.validator;

import org.springframework.stereotype.Service;

@Service
public class LoginFormValidator extends FormValidator {



    boolean validLogin(String login){
        return isNullLogin(login) ||
                isEmptyLogin(login) ||
                isToShort(login);
    }

    private boolean isNullLogin(String login) {
        return login == null;
    }

    private boolean isEmptyLogin(String login){
        return login.isEmpty();
    }

    @Override
    protected boolean isToShort(String login) {
        return super.isToShort(login);
    }


}
