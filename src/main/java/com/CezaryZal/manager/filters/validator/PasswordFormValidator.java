package com.CezaryZal.manager.filters.validator;

import org.springframework.stereotype.Service;

@Service
public class PasswordFormValidator extends FormValidator {

    boolean validPassword(String passwordFromUserLogin){
        return isNullPassword(passwordFromUserLogin) ||
                isEmptyPassword(passwordFromUserLogin) ||
                isToShort(passwordFromUserLogin);
    }

    private boolean isNullPassword(String password){
        return password == null;
    }

    private boolean isEmptyPassword(String password){
        return password.isEmpty();
    }

    @Override
    protected boolean isToShort(String password) {
        return super.isToShort(password);
    }


}
