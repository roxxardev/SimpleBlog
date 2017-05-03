package com.pollub.repository;

import com.pollub.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Eryk on 2017-04-13.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
