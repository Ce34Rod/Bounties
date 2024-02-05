package org.CERN.bounties.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StarterPageController {


    @GetMapping("starterPage")
    public String startPage(Model model){
        return "starterPage";
    }
}
