package com.caneda.app.controller;

/**
 * the two things I need to improve upon
 * is besides making much better code, is learning everything that spring boot has to offer
 * and to master controllers, while
 */

import java.util.List;
import com.caneda.app.entities.*;
import com.caneda.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/controller")
public class Controller_Caneda {

    @Autowired
    private AskUserInfo_Caneda askUserInfoCaneda;

    @PostMapping("/Users")
    public User_Caneda createUser(@RequestBody User_Caneda user) {
        return askUserInfoCaneda.createUser(user.getUserName(), user.getUserAge(), user.getUserEmail(), user.getUserCountry(), user.getUserRole());
    }

    @Autowired
    private Greetings_Caneda greetingsCaneda;

    @PostMapping("/Greet")
    public String userGreetings(@RequestBody User_Caneda user) {
        greetingsCaneda.userGreeting(user.getUserName(), user.getUserCountry());
        return "How are you?";
    }

    @Autowired
    private ProductService_Caneda productService;

    @PostMapping("/products")
    public Product_Caneda createProduct(@RequestBody Product_Caneda product) {
        return productService.createProduct(product.getProductName(), product.getDescription(), product.getPrice(), product.getQuantity(), product.getCategory());
    }

    @Autowired
    private ProductInfo_Caneda productInfoCaneda;

    @PostMapping("/ShowProduct")
    public void showProduct(@RequestParam String productName){
        productInfoCaneda.showProduct(productName);
    }

    @GetMapping("/Users")
    public List<User_Caneda> getAllUsers() {
        return askUserInfoCaneda.getAllUsers();
    }

    @GetMapping("/Users/{id}")
    public User_Caneda getUserById(@PathVariable long id) {
        return askUserInfoCaneda.getUserById(id);
    }

    @PutMapping("/Users/{id}")
    public User_Caneda updateUser(@PathVariable long id, @RequestBody User_Caneda user) {
        return askUserInfoCaneda.updateUser(id, user);
    }

    @DeleteMapping("/Users/{id}")
    public void deleteUser(@PathVariable long id) {
        askUserInfoCaneda.deleteUser(id);
    }

    @GetMapping("/products")
    public List<Product_Caneda> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product_Caneda getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/products/{id}")
    public Product_Caneda updateProduct(@PathVariable long id, @RequestBody Product_Caneda product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
