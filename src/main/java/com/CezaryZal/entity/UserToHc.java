package com.CezaryZal.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users_to_hc")
@Data
@NoArgsConstructor
public class UserToHc {

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
