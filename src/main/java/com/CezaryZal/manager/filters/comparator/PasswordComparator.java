package com.CezaryZal.manager.filters.comparator;

import com.CezaryZal.exceptions.IncorrectLoginOrPasswordSecurityException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class PasswordComparator {

    public void throwIfIsNotEqualsPassword(String passwordFromUserLogin, String userPasswordFromDb) {
        if (!BCrypt.checkpw(passwordFromUserLogin, userPasswordFromDb)){
            throw new IncorrectLoginOrPasswordSecurityException("Login or password incorrectly entered");
        }
    }
}
