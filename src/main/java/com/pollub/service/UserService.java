package com.pollub.service;

import com.pollub.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.util.List;

/**
 * Created by Eryk on 2017-04-13.
 */

@Service
public interface UserService extends UserDetailsService {
    void save(User user);

    User findByUsername(String username);

    List<User> findAll();

    void delete(long id);

    User findByEmail(String email);

    boolean usernameExists(String username);

    void changePassword(String currentPassword, String newPassword) throws AuthException;

    void changeAbout(String info);

    User findLoggedInUser();

    void autoLogin(String username, String password);
}
