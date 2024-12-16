package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class BookDto {
    private String title;
    private String isbn;
    private Date publicationYear;
    private String publisher;
    private List<Long> authors; // IDs of selected authors
    private List<Long> categories; // IDs of selected categories

}
