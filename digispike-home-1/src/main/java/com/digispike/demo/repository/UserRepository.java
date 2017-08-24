package com.digispike.demo.repository;

import com.digispike.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Devon Ravihansa on 8/23/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
