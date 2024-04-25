package org.CERN.bounties.controllers;

import org.CERN.bounties.models.User;
import org.CERN.bounties.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String passName(@ModelAttribute User user) {

        User savedUser = userRepository.save(new User(user.getName()));

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
        return "starterPage";
    }
}
