package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.EmptyObjectException;
import com.CezaryZal.exceptions.ToShortStringException;
import org.springframework.stereotype.Service;

@Service
public class LoginFormValidator extends FormValidator {


    void validLogin(String login) {
        throwExceptionIfLoginIsNull(login);
        throwExceptionIfLoginIsEmptyLogin(login);
        isToShort(login);
    }

    private void throwExceptionIfLoginIsNull(String login) {
        if (login == null){
            throw new NullPointerException("Input login is null");
        }
    }

    private void throwExceptionIfLoginIsEmptyLogin(String login) {
        if (login.isEmpty()){
            throw new EmptyObjectException("Input login is empty");
        }
    }

    @Override
    protected boolean isToShort(String login) {
        if (super.isToShort(login)){
            throw new ToShortStringException("Input login is short");
        }
        return true;
    }


}
