package com.pollub.controller;

import com.pollub.model.User;
import com.pollub.service.UserService;
import com.pollub.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;


/**
 * Created by Eryk on 2017-04-13.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if(bindingResult.hasErrors()) {
            return "registration";
        }
        String userPassword = userForm.getPassword();
        userService.save(userForm);
        userService.autoLogin(userForm.getUsername(), userPassword);

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if(error != null) {
            model.addAttribute("error", "Your username/password is invalid.");
        }
        if(logout != null) {
            model.addAttribute("message", "Your have been logged out.");
        }
        return "login";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping(value = "/profile/{username}", method = RequestMethod.GET)
    public String profile(@PathVariable("username") String username, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }

    @RequestMapping(value = "/profile/{username}/edit", method = RequestMethod.GET)
    public String editProfile(@PathVariable("username") String username, Model model) {
        model.addAttribute("user", userService.findByUsername(username));
        return "editProfile";
    }

    @RequestMapping(value = "/profile/{username}/edit", method = RequestMethod.POST)
    public String editProfile(@PathVariable("username") String username, @ModelAttribute User user) {
        userService.changeAbout(user.getAbout());

        return "redirect:/profile/{username}";
    }

    @RequestMapping(value = "/profile/{username}/delete")
    public String deleteAccount(@PathVariable("username") String username) {
        User loggedInUser = userService.findLoggedInUser();
        if(username.equals(loggedInUser.getUsername())) {
            userService.delete(loggedInUser.getId());
            return "redirect:/logout";
        }

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        boolean hasRole = false;
        for (GrantedAuthority authority : authorities) {
            hasRole = authority.getAuthority().equals("ROLE_ADMIN");
            if (hasRole) {
                break;
            }
        }

        if(hasRole) {
            userService.delete(userService.findByUsername(username).getId());
        }

        return "redirect:/list";
    }
}
