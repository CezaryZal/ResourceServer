package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.EmptyObjectException;
import com.CezaryZal.exceptions.NullInputException;
import com.CezaryZal.exceptions.ToShortStringException;
import org.springframework.stereotype.Service;

@Service
public class PasswordFormValidator extends FormValidator {

    void validPassword(String passwordFromUserLogin) {
        isNullPassword(passwordFromUserLogin);
        isEmptyPassword(passwordFromUserLogin);
        isToShort(passwordFromUserLogin);
    }

    private void isNullPassword(String password) {
        if (password == null) {
            throw new NullInputException("Input password is null");
        }
    }

    private void isEmptyPassword(String password) {
        if (password.isEmpty()) {
            throw new EmptyObjectException("Input password is empty");
        }
    }

    @Override
    protected boolean isToShort(String password) {
        if (super.isToShort(password)){
            throw new ToShortStringException("Input password is to short");
        }
        return true;
    }


}
