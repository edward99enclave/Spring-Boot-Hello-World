package com.spring.demo.database;

import com.spring.demo.models.Product;
import com.spring.demo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// This class was called right after the application ran.
// To initialize env, database,...
// Declare some bean method that it was called right after the app ran.
public class Database {
    // declare logger to print out screen
    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product( "iPhone 13 Pro Max", 2021);
                Product productB = new Product("iPhone 12 Pro Max", 2020);
                Product productC = new Product("iPhone 11 Pro Max", 2019);
//                System.out.println("insert data: " + productRepository.save(productA));
//                System.out.println("insert data: " + productRepository.save(productB));
                logger.info("insert data: " + productRepository.save(productA));
                logger.info("insert data: " + productRepository.save(productB));
                logger.info("insert data: " + productRepository.save(productC));
            };
        };
    }
}
