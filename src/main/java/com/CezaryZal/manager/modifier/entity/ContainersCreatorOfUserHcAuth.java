package com.CezaryZal.manager.modifier.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainersCreatorOfUserHcAuth {

    public List<String> getRoleList(String roles){
        if(roles.length() > 0){
            return Arrays.asList(roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(String permissions){
        if(permissions.length() > 0){
            return Arrays.asList(permissions.split(","));
        }
        return new ArrayList<>();
    }
}
