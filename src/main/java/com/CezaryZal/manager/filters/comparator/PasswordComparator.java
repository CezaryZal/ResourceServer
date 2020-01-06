package com.CezaryZal.manager.filters.comparator;

import com.CezaryZal.exceptions.IncorrectLoginOrPasswordSecurityException;
import org.springframework.stereotype.Service;

@Service
public class PasswordComparator {

    public void throwIsNotEqualsPassword(String passwordFromUserLogin, String userPasswordFromDb) {
        if (!passwordFromUserLogin.equals(userPasswordFromDb)){
            throw new IncorrectLoginOrPasswordSecurityException("Login or password incorrectly entered");
        }
    }
}
