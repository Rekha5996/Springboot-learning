package com.rest.webservices.learning.rest.repository;

import com.rest.webservices.learning.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
