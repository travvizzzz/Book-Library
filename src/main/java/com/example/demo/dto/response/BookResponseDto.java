package com.example.demo.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponseDto 
{

    private Long id;
    private String name;
    private String author;
    private String isbn;
    private Long categoryId;      
    private String categoryName; 
}