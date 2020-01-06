package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.EmptyObjectException;
import com.CezaryZal.exceptions.NullInputException;
import com.CezaryZal.exceptions.ToShortStringException;
import org.springframework.stereotype.Service;

@Service
public class LoginFormValidator extends FormValidator {


    void validLogin(String login) {
        throwExceptionIfLoginIsNull(login);
        throwExceptionIfLoginIsEmptyLogin(login);
        throwIfIsToShort(login);
    }

    private void throwExceptionIfLoginIsNull(String login) {
        if (login == null){
            throw new NullInputException("Input login is null");
        }
    }

    private void throwExceptionIfLoginIsEmptyLogin(String login) {
        if (login.isEmpty()){
            throw new EmptyObjectException("Input login is empty");
        }
    }

    @Override
    protected boolean throwIfIsToShort(String login) {
        if (super.throwIfIsToShort(login)){
            throw new ToShortStringException("Input login is to short");
        }
        return true;
    }


}
