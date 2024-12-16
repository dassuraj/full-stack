package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class AuthorDto {
    private Long id;
    private String name;

    public AuthorDto(Long id,String name){
        this.id=id;
        this.name=name;
    }
}
