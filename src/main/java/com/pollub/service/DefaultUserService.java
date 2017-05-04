package com.pollub.service;

import com.pollub.model.Role;
import com.pollub.model.User;
import com.pollub.repository.RoleRepository;
import com.pollub.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.message.AuthException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Eryk on 2017-05-03.
 */

@Service("userService")
public class DefaultUserService implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultUserService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        user.setRegistrationDate(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public boolean usernameExists(String username) {
        return findByUsername(username) != null;
    }

    @Override
    public void changePassword(String currentPassword, String newPassword) throws AuthException {
        User user = findLoggedInUser();

        if(!bCryptPasswordEncoder.matches(currentPassword, user.getPassword()))
            throw new AuthException("Password does not match");

        user.setPassword(bCryptPasswordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void changeAbout(String info) {
        User user = findLoggedInUser();
        user.setAbout(info);
        userRepository.save(user);
    }

    @Override
    public User findLoggedInUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        return userRepository.findByUsername(authentication.getName());
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = loadUserByUsername(username);
        logger.info(username + " " + password);
        logger.info(userDetails.getUsername() + " " + userDetails.getPassword());
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,password, userDetails.getAuthorities());

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        if(usernamePasswordAuthenticationToken.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            logger.info(String.format("Auto login %s successfully!", username));
        }
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            logger.info("role = " + role.getName());
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
