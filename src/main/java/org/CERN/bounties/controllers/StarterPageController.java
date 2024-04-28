package org.CERN.bounties.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.CERN.bounties.models.User;
import org.CERN.bounties.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class StarterPageController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public String writeName(Model model) {
        model.addAttribute(new User());
        {
            return "starterPage";
        }
    }

    @PostMapping("/")
    public String passName(@ModelAttribute @Valid User user, HttpServletResponse response) {

        userRepository.save(user);
        User savedUser = user;

        if (user != null) {
            // User found, set username as a cookie
            Cookie cookie = new Cookie("username", user.getName());
            cookie.setMaxAge(30 * 24 * 60 * 60); // Cookie will expire in 30 days
            response.addCookie(cookie);
        }


        if (savedUser != null) {
            System.out.println("Saved user to database");
        } else {
            System.out.println("Failed to save user to database");
        }

        User retrievedUser = userRepository.findById(savedUser.getId()).orElse(null);
        if (retrievedUser != null) {
            System.out.println("Retrieved user object from database");
        } else {
            System.out.println("Failed to retrieve user object from database");
        }
        return "redirect:/welcome"+ "?username=" + user.getName();
    }

    @GetMapping("/welcome")
    public String welcomeHunter(Model model, @RequestParam("username") String username, HttpServletResponse response){


        Optional<User> user = userRepository.findById(3);
        model.addAttribute("name", username);


        return "welcome";
        }




    }

