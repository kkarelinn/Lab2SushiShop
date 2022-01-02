package com.example.lab2sushishop.controllers;

import com.example.lab2sushishop.model.repositories.RepositOrder;
import com.example.lab2sushishop.model.repositories.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    Repositor repositor;

    @Autowired
    public OrderController(RepositOrder repositor) {
        this.repositor = repositor;
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("orders", repositor.getList());
        return "orders/showOrders";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("order", repositor.show(id));
        return "orders/editOrders";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/orders";
    }
}

