package com.CezaryZal.entity.health.calendar;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_hc")
@Data
@NoArgsConstructor
public class UserAuthentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginName;
    private String password;
    private boolean approved;
    private String roles;
    private String permissions;

    private Long userId;

}
