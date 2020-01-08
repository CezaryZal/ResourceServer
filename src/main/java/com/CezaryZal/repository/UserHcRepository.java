package com.CezaryZal.repository;

import com.CezaryZal.entity.UserHc;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserHcRepository extends CrudRepository<UserHc, Long> {

    Optional<UserHc> findByLoginName(String loginName);
}
