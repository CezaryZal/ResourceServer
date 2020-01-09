package com.CezaryZal.entity.app;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "users_app")
@Getter
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginName;
    private String password;
    private String roles;

}
