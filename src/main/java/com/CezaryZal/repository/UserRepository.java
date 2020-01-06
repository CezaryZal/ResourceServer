package com.CezaryZal.repository;

import com.CezaryZal.entity.UserToDb;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserToDb, Long> {

    Optional<UserToDb> findByLoginName(String loginName);
}
