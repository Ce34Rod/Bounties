package org.CERN.bounties.controllers;

import org.CERN.bounties.models.Bounty;
import org.CERN.bounties.models.data.BountyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private BountyRepository bountyRepository;
    @RequestMapping("")
    public String search(Model model){
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        Iterable<Bounty> bounties;
        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
            bounties = bountyRepository.findAll();
        } else {
            bounties =
        }
    }
}
