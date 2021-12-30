package com.example.lab2sushishop.controllers;


import com.example.lab2sushishop.model.User;
import com.example.lab2sushishop.model.repositories.RepositUser;
import com.example.lab2sushishop.model.repositories.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    final Repositor repositor;

    @Autowired
    public UserController(RepositUser repositor) {
        this.repositor = repositor;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", repositor.getList());
        return "users/showUsers";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", repositor.show(id));
        return "users/editUser";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        user.setID(id);
        repositor.update(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "users/addNew";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        repositor.addNew(user);
        return "redirect:/users";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/users";
    }
}