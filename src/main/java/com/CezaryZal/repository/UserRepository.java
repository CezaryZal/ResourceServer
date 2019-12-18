package com.CezaryZal.repository;

import com.CezaryZal.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByLoginName(String loginName);
}
