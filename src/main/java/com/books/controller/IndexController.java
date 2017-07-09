package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.books.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views-base-index";
    }

    @PostMapping("/")
    public String indexAfterLogin(Model model) {
        model.addAttribute("users", userService.findAll());
        return "views-base-index";
    }

    @GetMapping("/openUserView")
    public String user() {
        return "views-user-listOfUsers";
    }

    @GetMapping("/openCityView")
    public String magazine() {
        return "views-magazine-listOfMagazine";
    }

    @GetMapping("/openBookView")
    public String book() {
        return "views-user-listOfBooks";
    }


}