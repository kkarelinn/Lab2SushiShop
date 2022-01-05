package com.example.lab2sushishop.controllers;


import com.example.lab2sushishop.model.Product;
import com.example.lab2sushishop.model.repositories.RepositProduct;
import com.example.lab2sushishop.model.repositories.Repositor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/products")
public class ProductController {

Repositor repositor;

    @Autowired
    public ProductController(RepositProduct repositor) {
        this.repositor = repositor;
    }
    @GetMapping
    public String index(Model model) {
        model.addAttribute("products", repositor.getList());
        return "products/showProd";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
       model.addAttribute("product", repositor.show(id));
        return "products/editProd";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "products/editProd";

        repositor.update(product);
        return "redirect:/products";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product) {
       return "products/addNew";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "products/addNew";
        repositor.addNew(product);
        return "redirect:/products";
    }

   @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/products";
    }
}
