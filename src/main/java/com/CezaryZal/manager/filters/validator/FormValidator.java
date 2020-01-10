package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.FormUser;
import com.CezaryZal.entity.app.AuthenticationRequest;
import org.springframework.stereotype.Service;


@Service
public class FormValidator {

    private static final int MIN_LENGTH = 3;

    boolean isEmpty(FormUser formUser) {
        return formUser == null;
    }

    protected boolean throwIfIsToShort(String checkArgument) {
        return checkArgument.length() <= MIN_LENGTH;
    }

}
