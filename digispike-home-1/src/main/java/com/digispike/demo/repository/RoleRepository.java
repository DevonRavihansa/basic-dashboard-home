package com.digispike.demo.repository;

import com.digispike.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Devon Ravihansa on 8/23/2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    void deleteByIdIn(List<Long> longs);
}
