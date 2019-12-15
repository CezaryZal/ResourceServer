package com.CezaryZal.repository;

import com.CezaryZal.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
