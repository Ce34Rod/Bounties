package org.CERN.bounties.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.CERN.bounties.models.User;
import org.CERN.bounties.models.data.UserRepository;
import org.CERN.bounties.models.dto.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthenticationController {


    private static final String userSessionKey = "user";

    private static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
        System.out.println(userSessionKey+user.getId());
    }

    @Autowired
    UserRepository userRepository;


    @GetMapping("/login")
    public String displayLoginForm(Model model, HttpSession session) {
        model.addAttribute(new LoginFormDTO());
        model.addAttribute("title", "Log In");
        return "login";
    }

    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO, Errors errors, HttpServletRequest request, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Log In");
            return "login";
        }

        Optional<User> optionalUser = userRepository.findById(loginFormDTO.getBadgeNumber());

        if (optionalUser.isPresent()) {
            User theUser = optionalUser.get();
            setUserInSession(request.getSession(), theUser);
            return "redirect:/welcome" + "?username=" + theUser.getName();
        } else {
            errors.rejectValue("password", "login.invalid", "Invalid username or password");
            model.addAttribute("title", "Log In");
            return "login";
        }
    }

}
