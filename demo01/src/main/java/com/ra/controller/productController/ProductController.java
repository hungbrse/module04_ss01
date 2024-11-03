package com.ra.controller.productController;

import com.ra.model.entity.Product;
import com.ra.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable long id, @ModelAttribute Product product) {
        product.setId(id);
        productService.save(product);
        return "redirect:/product";
    }
}
