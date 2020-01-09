package com.CezaryZal.repository;

import com.CezaryZal.entity.app.UserApp;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAppRepository extends CrudRepository<UserApp, Long> {

    Optional<UserApp> findByLoginName(String loginName);
}
