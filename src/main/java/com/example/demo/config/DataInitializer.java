package com.example.demo.config;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner seedProducts(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(Product.builder()
                        .name("Assassins Creed Shadows PS5")
                        .image("/img/digitales-ps5-assassins-creed-shadows-ps5.jpg")
                        .rating(4.7)
                        .reviews(324)
                        .price(23000.0)
                        .featured(true)
                        .build());
                repository.save(Product.builder()
                        .name("Metal Gear Solid Delta: Snake Eater PS5")
                        .image("/img/QT04935.jpg")
                        .rating(4.7)
                        .reviews(324)
                        .price(25000.0)
                        .featured(true)
                        .build());
                repository.save(Product.builder()
                        .name("Nintendo Switch 2")
                        .description("Consola Nintendo Switch con accesorios incluidos.")
                        .image("/img/official-switch2-button-1737038723306.jpg")
                        .price(500990.0)
                        .rating(4.5)
                        .reviews(120)
                        .featured(false)
                        .build());
            }
        };
    }
}