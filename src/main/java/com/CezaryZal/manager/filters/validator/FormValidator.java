package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.FormUser;
import com.CezaryZal.entity.app.AuthenticationRequest;
import org.springframework.stereotype.Service;


@Service
public abstract class FormValidator {

    private static final int MIN_LENGTH = 3;

    boolean isNull(FormUser formUser) {
        return formUser == null;
    }

    boolean isNull(String arg){
        return arg == null;
    }

    protected boolean throwIfIsToShort(String checkArgument) {
        return checkArgument.length() <= MIN_LENGTH;
    }

}
