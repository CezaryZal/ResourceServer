package com.CezaryZal.repository;

import com.CezaryZal.entity.health.calendar.UserAuthentication;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserHcAuthRepository extends CrudRepository<UserAuthentication, Long> {

    Optional<UserAuthentication> findByLoginName(String loginName);
}
