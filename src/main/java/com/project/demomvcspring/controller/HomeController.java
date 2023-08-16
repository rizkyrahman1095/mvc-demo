package com.project.demomvcspring.controller;

import com.project.demomvcspring.entity.Product;
import com.project.demomvcspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {

    private ProductService service;

    @Autowired
    public HomeController(ProductService service) {
        this.service = service;

    }


    @GetMapping
    public String welcome(Model model) {


        String massages = "Hallo MVC Play";
        model.addAttribute("message", massages);
        model.addAttribute("products", service.findAll());

        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "/product/add";
    }

    @PostMapping("/save")
    public String save(Product product, Model model) {
        service.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String dellete(@PathVariable("id") long id) {
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("product",service.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Product product, Model model) {

        return "redirect:/";
    }
}
