package com.example.lab2sushishop.controllers;


import com.example.lab2sushishop.model.User;
import com.example.lab2sushishop.model.UserAccess;
import com.example.lab2sushishop.model.repositories.RepositUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    final RepositUser repositor;

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
        model.addAttribute("roles", Arrays.asList(UserAccess.values()));
        return "users/editUser";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        user.setID(id);
        repositor.update(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", Arrays.asList(UserAccess.values()));

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

    @ModelAttribute("userMan")
    public List<User> listWithEmpty() {
        List<User> listWithEmpty = repositor.getList();
        listWithEmpty.add(new User());
        return listWithEmpty;
    }

}
