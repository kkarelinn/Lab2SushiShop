package com.example.lab2sushishop.controllers;


import com.example.lab2sushishop.model.Category;
import com.example.lab2sushishop.model.Product;
import com.example.lab2sushishop.model.repositories.RepositProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/products")

public class ProductController {

RepositProduct repositor;

    @Autowired
    public ProductController(RepositProduct repositor) {
       this.repositor = repositor;
    }
    @GetMapping
    public String index(Model model) {
            model.addAttribute("prodList", repositor.getList());
        return "products/showProd";
    }

    @GetMapping("/{id}")
    public String show(@ModelAttribute("product") Product product, @PathVariable("id") int id, Model model) {

       model.addAttribute("product", repositor.show(id));

        return "products/editProd";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors())
            return "products/editProd";

        product.setLinkProduct(repositor.show(product.getLinkprod_id()));
        product.setCategory(repositor.getCatById(product.getCategory_id()));

        repositor.update(product);
        return "redirect:/products";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product, Model model) {
       return "products/addNew";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "products/addNew";
        System.out.println(product);
        product.setLinkProduct(repositor.show(product.getLinkprod_id()));
        product.setCategory(repositor.getCatById(product.getCategory_id()));
        repositor.addNew(product);
        return "redirect:/products";
    }
    @ModelAttribute("cats")
    public List<Category> categoryList(){
        return repositor.getListCats();
    }
    @ModelAttribute("prods")
    public List<Product> listWithEmpty(){
        List<Product> listWithEmpty = repositor.getList();
        listWithEmpty.add(new Product());
        return listWithEmpty;
    }



   @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/products";
    }
}
