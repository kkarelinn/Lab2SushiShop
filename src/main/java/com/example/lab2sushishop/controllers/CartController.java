package com.example.lab2sushishop.controllers;

import com.example.lab2sushishop.Log.Loging;
import com.example.lab2sushishop.model.*;
import com.example.lab2sushishop.model.repositories.RepositCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/carts")
public class CartController {

    private final static double COURSE_USD = 27.55;
    RepositCart repositor;
    final Order order;
    Cart tempCart;
    List<Order> tempOrderList;

    @Autowired
    public CartController(RepositCart repositor, Order order, Cart tempCart) {
        this.repositor = repositor;
        this.order = order;
        this.tempCart = tempCart;
    }
    @Loging
    @GetMapping()
    public String index(Model model) {
        updateCart();
        model.addAttribute("tempOrders", tempOrderList);
        model.addAttribute("tempCart", tempCart);
        model.addAttribute("products", repositor.getProdList());
        model.addAttribute("order", order);

        return "cart/showList";
    }
    @Loging
    @PostMapping("/add")
    public String update(@ModelAttribute("order") @Valid Order order, BindingResult bindingResult,
                         @RequestParam("priceUsd") double priceUsd,
                         @RequestParam("prod_id") int prod_id,
                         @RequestParam("cat_id") int cat_id) {

        if (bindingResult.hasErrors())
            return "redirect:/carts";
        order.setProduct(repositor.getProdById(prod_id));
        order.getProduct().setCategory(repositor.getCatById(cat_id));
        order.setTotal_price_uah(Math.round(priceUsd * COURSE_USD * order.getQuantity() * 100) / 100d);
        tempOrderList.add(order);
        return "redirect:/carts";
    }

    @Loging
    @GetMapping("/details")
    public String addDetails(Model model) {
        model.addAttribute("cart", tempCart);
        model.addAttribute("clients", repositor.getClientList());
        return "cart/addNew";
    }
    @Loging
    @PostMapping("/newCart")
    public String newCart(@ModelAttribute("cart") @Valid Cart cart, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "cart/addNew";

        cart.setTotalPrice_uah(tempCart.getTotalPrice_uah());
        repositor.addNew(cart);
        int cart_ID = repositor.getLastCartID();
        for (Order order: tempOrderList) {
            order.setCart_ID(cart_ID);
            repositor.addNewOrder(order);
        }
        model.addAttribute("tempOrders", tempOrderList);
        model.addAttribute("cart", cart);
        System.out.println(repositor.getClient(cart.getClient_ID()));
        model.addAttribute("client", repositor.getClient(cart.getClient_ID()));

        return "cart/approve";
    }

    @Loging
    @GetMapping("/del")
    public String delete() {

        tempCart.setTotalPrice_uah(0);
        tempOrderList = null;
        return "redirect:/carts";
    }

    @Loging
    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/carts/allcarts";
    }

    @Loging
    @GetMapping("/allcarts")
    public String showCarts(Model model) {
        model.addAttribute("carts", repositor.getList());
        return "cart/showAll";
    }

    private void updateCart() {
        if (tempOrderList == null) {
            tempOrderList = new ArrayList<>();
        } else {
            double totalPr = 0;
            for (Order order : tempOrderList) {
                totalPr += order.getTotal_price_uah();
            }
            tempCart.setTotalPrice_uah(Math.round(totalPr * 100) / 100d);
        }

    }
}
