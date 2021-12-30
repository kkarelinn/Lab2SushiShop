package com.example.lab2sushishop.controllers;


import com.example.lab2sushishop.model.Product;
import com.example.lab2sushishop.model.repositories.Repositor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
            @Qualifier("repositProduct")
Repositor repositor;

  /*  @Autowired
    public ProductController(RepositProduct repositor) {
        this.repositor = repositor;
    }
*/
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

    @PostMapping("/{id}/edit")
    public String update(@ModelAttribute("product") Product product, @PathVariable("id") int id)
    {
        product.setID(id);
       repositor.update(product);
        return "redirect:/products";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "products/addNew";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") Product product) {
        repositor.addNew(product);
        return "redirect:/products";
    }

   @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/products";
    }
}
