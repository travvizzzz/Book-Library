package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private String author;

    @Column(unique = true, nullable = false, length = 20)
    private String isbn;

    // Many books can belong to one category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}