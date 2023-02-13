package ca.sheridancollege.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Assignment2;

@Controller
public class HomeController {

    private List<Assignment2> users = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new Assignment2());
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Assignment2 user, Model model) {
        users.add(user);
        model.addAttribute("user", new Assignment2());
        model.addAttribute("users", users);
        return "index";
    }
    @PostMapping("/reset")
    public String reset(Model model) {
        users.clear();
        model.addAttribute("user", new Assignment2());
        model.addAttribute("users", users);
        model.addAttribute("isEmpty", users.isEmpty());
        return "index";
    }
}
