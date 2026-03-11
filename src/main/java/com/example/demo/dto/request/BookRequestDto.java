package com.example.demo.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRequestDto 
{

    private String name;
    private String author;
    private String isbn;
    private Long categoryId; 
    
}