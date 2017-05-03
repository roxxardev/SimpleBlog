package com.pollub.service;

import com.pollub.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Eryk on 2017-04-13.
 */

@Service
public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

    void delete(long id);
}
