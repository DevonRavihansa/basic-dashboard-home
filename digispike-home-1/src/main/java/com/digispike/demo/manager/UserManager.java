package com.digispike.demo.manager;

import com.digispike.demo.model.Role;
import com.digispike.demo.model.User;
import com.digispike.demo.repository.RoleRepository;
import com.digispike.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserManager implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User admin = userRepository.findByUsername("admin");
        if (admin == null) {
            roleRepository.deleteByIdIn(Arrays.asList(1L, 2L));
            Set<Role> roles = new HashSet<>(2);
            Role role = new Role();
            role.setId(1L);
            role.setRole("ROLE_ADMIN");
            roles.add(role);

            role = new Role();
            role.setId(2L);
            role.setRole("ROLE_USER");
            roles.add(role);
            roleRepository.save(roles);

            User user = new User();
            user.setUsername("admin");
            user.setPassword("admin");
            user.setRoles(roles);
            userRepository.save(user);
        }


    }
}
