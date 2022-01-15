package com.example.lab2sushishop.controllers;

import com.example.lab2sushishop.services.GetUSDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping()
    public String main(Model model) {

        model.addAttribute("main", "Sushi SHOP");

        return "index";
    }
}