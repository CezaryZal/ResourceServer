package com.CezaryZal.manager.filters.comparator;

import org.springframework.stereotype.Service;

@Service
public class PasswordComparator {

    public boolean isEqualsPassword(String passwordFromUserLogin, String userPasswordFromDb) {
        return passwordFromUserLogin.equals(userPasswordFromDb);
    }
}
