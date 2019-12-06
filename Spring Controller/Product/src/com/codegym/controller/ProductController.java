package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/products")
    public ModelAndView list() {
        List<Product> products = this.productService.findAll();
        ModelAndView modelAndView = new ModelAndView("product/list");
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createProduct(@ModelAttribute("product") Product product) {
        int randomId = (int) (Math.random() * 10000);
        product.setId(randomId);//For demo purpose only

        this.productService.save(product);

        ModelAndView modelAndView = new ModelAndView("product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product was created");
        return modelAndView;
    }

    @GetMapping(value = "/view")
    public ModelAndView view(@RequestParam("id") Integer productId) {
        Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("product/view");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping(value = "/edit")
    public ModelAndView edit(@RequestParam("id") Integer productId) {
        Product product = this.productService.findById(productId);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

//    @PostMapping("/edit")
//    public ModelAndView editProduct(@ModelAttribute("product") Product product, @RequestParam String code,
//                                    String name, String price, String id) {
//        product.setCode(code);
//        product.setName(name);
//        product.setId(Integer.parseInt(price));
//        Product product = this.productService.findById(Integer.parseInt(id));
//        this.productService.update(Integer.parseInt(id), product);
//        return ;
//    }
}