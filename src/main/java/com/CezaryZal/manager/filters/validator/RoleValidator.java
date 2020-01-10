package com.CezaryZal.manager.filters.validator;

import com.CezaryZal.exceptions.IncorrectRoleException;
import com.CezaryZal.exceptions.NullInputException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoleValidator {

    List<String> listRoles = Arrays.asList("ADMIN", "USER", "VIEWER");

    void validRole(String role){
        throwIfRoleIsNull(role);
        throwIfRoleIsIncorrect(role);
    }

    private void throwIfRoleIsNull(String role){
        if (role == null){
            throw new NullInputException("Input role is null");
        }
    }

    private void throwIfRoleIsIncorrect(String role){
        if (!listRoles.contains(role)){
            throw new IncorrectRoleException("The role sent is incorrect");
        }
    }
}
