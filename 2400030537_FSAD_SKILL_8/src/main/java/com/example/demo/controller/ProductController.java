package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    // 🔹 Insert sample data
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // 🔹 Category search
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // 🔹 Price filter
    @GetMapping("/filter")
    public List<Product> filter(@RequestParam double min,
                               @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // 🔹 Sorted
    @GetMapping("/sorted")
    public List<Product> sorted() {
        return repo.getAllSorted();
    }

    // 🔹 Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensive(@PathVariable double price) {
        return repo.getExpensiveProducts(price);
    }
}