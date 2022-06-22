package com.spring.demo.controllers;

import com.spring.demo.models.Product;
import com.spring.demo.models.ResponseObject;
import com.spring.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // inform to system that here is class controller
@RequestMapping(path = "/api/v1/Products") // Routing
public class ProductController {
    // DI = Dependency Injection
    @Autowired
    private ProductRepository repository;

//    @GetMapping("") // GET: http://localhost:8080/api/v1/Products
//    ResponseEntity<ResponseObject> findAll() {
//        List<Product> productList = repository.findAll();
//        return productList.size() != 0 ?
//            ResponseEntity.status(HttpStatus.OK).body(
//                    new ResponseObject("ok", "Query list of product successfully", productList)
//            )
//            :
//            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                new ResponseObject("false", "Query list of product Failed", "")
//            );
//    };

    @GetMapping("") // GET: http://localhost:8080/api/v1/Products/{id}
//    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
    ResponseEntity<ResponseObject> findById(@RequestParam(value = "id", required = false) Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ?
            ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Query product successfully", foundProduct)
             )
            :
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("false", "Cannot find product with id = " + id, "")
            );
    }

    // Insert new Product with POST method
    // Body: raw, JSON
    @PostMapping("/create")  // POST: http://localhost:8080/api/v1/Products
    ResponseEntity<ResponseObject> createProduct(@RequestBody Product newProduct) {
        // check if the same name
        // List <Product> foundProduct = repository.findByProductName(newProduct.getProductName().trim());
        List <Product> foundProduct = repository.findByYear(newProduct.getYear());
        if (foundProduct.size() > 0) { // exist product
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("false", "Product Name Existed!", "")
            );
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Create New Product Successfully", repository.save(newProduct))
        );
    }
}
