package com.CezaryZal.repository;

import com.CezaryZal.entity.UserToHc;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserToHc, Long> {

    Optional<UserToHc> findByLoginName(String loginName);
}
