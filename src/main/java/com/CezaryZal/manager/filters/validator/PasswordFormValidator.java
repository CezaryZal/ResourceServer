package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.EmptyObjectException;
import com.CezaryZal.exceptions.NullInputException;
import com.CezaryZal.exceptions.ToShortStringException;
import org.springframework.stereotype.Service;

@Service
public class PasswordFormValidator extends FormValidator {

    void validPassword(String passwordFromUserLogin) {
        throwIfIsNullPassword(passwordFromUserLogin);
        throwIfIsEmptyPassword(passwordFromUserLogin);
        throwIfIsToShort(passwordFromUserLogin);
    }

    private void throwIfIsNullPassword(String password) {
        if (password == null) {
            throw new NullInputException("Input password is null");
        }
    }

    private void throwIfIsEmptyPassword(String password) {
        if (password.isEmpty()) {
            throw new EmptyObjectException("Input password is empty");
        }
    }

    @Override
    protected boolean throwIfIsToShort(String password) {
        if (super.throwIfIsToShort(password)){
            throw new ToShortStringException("Input password is to short");
        }
        return true;
    }


}
