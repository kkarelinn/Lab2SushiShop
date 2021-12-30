package com.example.lab2sushishop.controllers;



import com.example.lab2sushishop.model.Client;
import com.example.lab2sushishop.model.repositories.RepositClient;

import com.example.lab2sushishop.model.repositories.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "clients/editClient";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("client") Client client, @PathVariable("id") int id) {
        client.setID(id);
        repositor.update(client);
        return "redirect:/clients";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("client") Client client) {
        return "clients/addNew";
    }

    @PostMapping()
    public String create(@ModelAttribute("client") Client client) {
        repositor.addNew(client);
        return "redirect:/clients";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/clients";
    }
}