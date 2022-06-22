package com.spring.demo.controllers;

import com.spring.demo.models.Product;
import com.spring.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // inform to system that here is class controller
@RequestMapping(path = "/api/v1/Products") // Routing
public class ProductController {
    // DI = Dependency Injection
    @Autowired
    private ProductRepository repository;

    @GetMapping("") // GET,POST,DELETE MAPPING...
    // GET: http://localhost:8080/api/v1/Products
    List<Product> getAllProducts() {
        return repository.findAll(); // where is data?
    }
    // Must save this to Database, use H2 DB (In-memory Database).

}
