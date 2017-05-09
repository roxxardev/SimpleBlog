package com.pollub.repository;

import com.pollub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Eryk on 2017-04-13.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmailIgnoreCase(String email);
}
