package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.NullInputException;
import com.CezaryZal.exceptions.ToShortStringException;
import org.springframework.stereotype.Service;

@Service
public class LoginFormValidator extends FormValidator {

    void validLogin(String login) {
        throwExceptionIfLoginIsNull(login);
        throwIfIsToShort(login);
    }

    private void throwExceptionIfLoginIsNull(String login) {
        if (isEmpty(login)){
            throw new NullInputException("Input login is null");
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
