package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.entity.AuthenticationRequest;
import org.springframework.stereotype.Service;


@Service
public class FormValidator {

    private static final int MIN_LENGTH = 3;

    boolean isEmpty(AuthenticationRequest authenticationRequest) {
        return authenticationRequest == null;
    }

    protected boolean throwIfIsToShort(String checkArgument) {
        return checkArgument.length() <= MIN_LENGTH;
    }

}
