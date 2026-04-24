package com.genos.sindeps.controller;

import com.genos.sindeps.entity.Product;
import com.genos.sindeps.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private ProductRepository repo1;

    @GetMapping("/products")
    public List<Product> getProduct()
    {
        return repo1.findAll();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) { //request body converts json data to data known by java
        return repo1.save(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
        product.setId(id);
        return repo1.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id) {
        repo1.deleteById(id);
    }
}
