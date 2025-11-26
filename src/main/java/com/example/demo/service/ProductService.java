package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Optional<Product> update(Long id, Product input) {
        return productRepository.findById(id).map(existing -> {
            existing.setName(input.getName());
            existing.setDescription(input.getDescription());
            existing.setImage(input.getImage());
            existing.setPrice(input.getPrice());
            existing.setRating(input.getRating());
            existing.setReviews(input.getReviews());
            existing.setFeatured(input.getFeatured());
            return productRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}