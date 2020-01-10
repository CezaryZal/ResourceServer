package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.InvalidEmailFormException;
import com.CezaryZal.exceptions.NullInputException;
import com.CezaryZal.exceptions.ToShortStringException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class EmailFormValidator extends FormValidator{

    void validEmail(String email) {
        throwExceptionIfEmailIsNull(email);
        throwExceptionIfEmailIsInvalid(email);
        throwIfIsToShort(email);
    }

    private void throwExceptionIfEmailIsNull(String email) {
        if (isNull(email)){
            throw new NullInputException("Input email is null");
        }
    }

    private void throwExceptionIfEmailIsInvalid(String email) {
        if (isValid(email)) {
            throw new InvalidEmailFormException("Invalid email form");
        }
    }

    @Override
    protected boolean throwIfIsToShort(String email) {
        if (super.throwIfIsToShort(email)){
            throw new ToShortStringException("Input email is to short");
        }
        return true;
    }

    private boolean isValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

        Pattern pat = Pattern.compile(emailRegex);

        return pat.matcher(email).matches();
    }
}
