package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.UserLogin;
import org.springframework.stereotype.Service;


@Service
public class FormValidator {

    private static final int MIN_LENGTH = 3;

    boolean isEmpty(UserLogin userLogin) {
        return userLogin == null;
    }

    protected boolean isToShort(String checkArgument) {
        return checkArgument.length() <= MIN_LENGTH;
    }

}
