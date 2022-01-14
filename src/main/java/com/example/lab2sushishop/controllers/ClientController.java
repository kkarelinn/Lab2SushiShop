package com.example.lab2sushishop.controllers;

import com.example.lab2sushishop.model.Client;
import com.example.lab2sushishop.model.repositories.RepositClient;
import com.example.lab2sushishop.model.repositories.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/clients")
public class ClientController {

    final Repositor repositor;

    @Autowired
    public ClientController(RepositClient repositor) {
        this.repositor = repositor;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("clients", repositor.getList());
        return "clients/showClients";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", repositor.show(id));
        System.out.println("id");
        return "clients/editClient";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "clients/editClient";

        repositor.update(client);
        return "redirect:/clients";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("client") Client client) {
        return "clients/addNew";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("client") @Valid Client client, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "clients/addNew";

        repositor.addNew(client);
        return "redirect:/clients";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/clients";
    }
}