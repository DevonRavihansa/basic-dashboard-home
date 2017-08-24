package com.digispike.demo.repository;

import com.digispike.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Devon Ravihansa on 8/23/2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
