package com.example.demo.service;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

    Book save(BookDto bookDto);


}
