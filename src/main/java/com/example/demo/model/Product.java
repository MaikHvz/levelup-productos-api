package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(nullable = false)
    private String image; // URL o ruta

    @Column(nullable = false)
    private Double price;

    @Column
    private Double rating; // 0.0 - 5.0

    @Column
    private Integer reviews; // cantidad de reseñas

    @Column(nullable = false)
    private Boolean featured = false;
}