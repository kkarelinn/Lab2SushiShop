package com.example.lab2sushishop.controllers;



import com.example.lab2sushishop.model.Category;
import com.example.lab2sushishop.model.repositories.RepositCategory;
import com.example.lab2sushishop.model.repositories.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/categories")
public class CategoryController {

    final Repositor repositor;

    @Autowired
    public CategoryController(RepositCategory repositor) {
        this.repositor = repositor;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", repositor.getList());
        return "categories/showCat";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", repositor.show(id));
        return "categories/editCat";
    }

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("category") Category category, @PathVariable("id") int id)
    {
        category.setID(id);
        repositor.update(category);
        return "redirect:/categories";
    }

    @GetMapping("/new")
    public String newCategory(@ModelAttribute("category") Category category) {
        return "categories/addNew";
    }

    @PostMapping()
    public String create(@ModelAttribute("category") Category category) {
        repositor.addNew(category);
        return "redirect:/categories";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/categories";
    }
}
