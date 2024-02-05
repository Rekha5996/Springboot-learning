package com.rest.webservices.learning.rest.repository;

import com.rest.webservices.learning.rest.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post,Integer> {
}
