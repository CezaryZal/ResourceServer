package com.CezaryZal.repository;

import com.CezaryZal.entity.health.calendar.UserAuthentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserHcAuthRepository extends CrudRepository<UserAuthentication, Long> {

    Optional<UserAuthentication> findByLoginName(String loginName);

    boolean existsUserAuthenticationByLoginName(String loginName);
}
