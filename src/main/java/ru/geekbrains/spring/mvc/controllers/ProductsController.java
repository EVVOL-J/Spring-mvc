package ru.geekbrains.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.mvc.model.Product;
import ru.geekbrains.spring.mvc.model.Student;
import ru.geekbrains.spring.mvc.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping
    public String showAllStudents(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        model.addAttribute("numberOfProducts",productService.numberOfProducts());
        model.addAttribute("averageCost",productService.averageCost());

        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    // public String saveNewStudent(@RequestParam Long id, @RequestParam String name, @RequestParam int score) {
    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product newProduct) {
        productService.addOrUpdate(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getById(id));
        return "edit_product_form";
    }

    @PostMapping("/edit")
    public String modifyProduct(@ModelAttribute Product modifiedProduct) {
        productService.addOrUpdate(modifiedProduct);
        return "redirect:/products/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return "redirect:/products/";
    }


}
