package com.example.lab2sushishop.controllers;


import com.example.lab2sushishop.model.*;
import com.example.lab2sushishop.model.repositories.RepositCart;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/carts")
public class CartController {

    private final static double COURCE_USD = 27.55;
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

    @GetMapping()
    public String index(Model model) {
        updateCart();
        model.addAttribute("cart", tempCart);
        model.addAttribute("cartStr", getProductsFromTempCart());
        model.addAttribute("products", repositor.getListProducts());
        model.addAttribute("order", order);

        return "cart/showList";
    }

    @PostMapping("/add")
    public String update(@ModelAttribute("order") @Valid Order order, BindingResult bindingResult, @RequestParam("priceUsd") double priceUsd) {

        if (bindingResult.hasErrors())
            return "redirect:/carts";
        System.out.println(order);
        System.out.println(priceUsd);
        order.setTotalOrdPriceUAH(Math.round(priceUsd * COURCE_USD * order.getQuantity() * 100) / 100d);
        System.out.println("Order: " + order);
        tempOrderList.add(order);
        return "redirect:/carts";
    }

    private List<String[]> getProductsFromTempCart() {
        List<String[]> cartStr = new ArrayList<>();
        for (Order ord : tempOrderList) {
            String[] str = repositor.getProd(ord.getProduct_ID());
            String[] full = new String[str.length + 2];
            System.arraycopy(str, 0, full, 0, str.length);
            full[full.length - 2] = ord.getQuantity() + "";
            full[full.length - 1] = ord.getTotalOrdPriceUAH() + "";
            cartStr.add(full);
        }
        return cartStr;
    }

    @GetMapping("/details")
    public String addDetails(Model model) {
        model.addAttribute("cart", tempCart);
        return "cart/addNew";
    }

    @PostMapping("/newCart")
    public String newCart(@ModelAttribute("cart") @Valid Cart cart, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "cart/addNew";

        cart.setTotalPriceUAH(tempCart.getTotalPriceUAH());
        int cart_ID = repositor.getLastCartID()+1;
        repositor.addNew(cart);

        for (Order order: tempOrderList) {
            order.setCart_ID(cart_ID);
            repositor.addNewOrder(order);
        }
        model.addAttribute("cartAp", cart);
        model.addAttribute("orders", repositor.getLinesFromCart(cart_ID));
        model.addAttribute("client", repositor.getClient(cart.getClient_ID()));

        return "cart/approve";
    }

    @GetMapping("/del")
    public String delete() {

        tempCart.setTotalPriceUAH(0);
        tempOrderList = null;
        return "redirect:/carts";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") int id) {
        repositor.delete(id);
        return "redirect:/carts/allcarts";
    }


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
                totalPr += order.getTotalOrdPriceUAH();
            }
            tempCart.setTotalPriceUAH(Math.round(totalPr * 100) / 100d);
        }

    }
}
