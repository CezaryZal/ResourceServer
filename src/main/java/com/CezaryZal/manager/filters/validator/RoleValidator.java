package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.IncorrectRoleException;
import com.CezaryZal.exceptions.NullInputException;
import org.springframework.stereotype.Component;

@Component
public class RoleValidator {

    void validRole(String role) {
        throwIfRoleIsNull(role);
        throwIfRoleIsIncorrect(isNotContains(role));
    }

    private void throwIfRoleIsNull(String role) {
        if (role == null) {
            throw new NullInputException("Input role is null");
        }
    }

    private void throwIfRoleIsIncorrect(boolean isNotContains) {
        if (isNotContains){
            throw new IncorrectRoleException("The role sent is incorrect");
        }
    }

    private boolean isNotContains(String inputRole){
        boolean contains = false;
        Roles[] roles = Roles.values();

        for (Roles role : roles) {
            if (role.name().equalsIgnoreCase(inputRole)) {
                contains = true;
                break;
            }
        }
        return !contains;
    }
}
