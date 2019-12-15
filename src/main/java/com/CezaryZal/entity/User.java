package com.CezaryZal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    private Long id;
    private String loginName;
    private String password;
    private boolean active;
    private String roles;
    private String permissions;

    private Long userId;
}
