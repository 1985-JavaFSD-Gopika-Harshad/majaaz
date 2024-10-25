package com.example.recipebook.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String cuisine;
    private String mealType;

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Lob
    private byte[] image;
}
