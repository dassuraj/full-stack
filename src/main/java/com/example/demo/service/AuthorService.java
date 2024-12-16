package com.example.demo.service;

import com.example.demo.entity.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {

   Author save(Author author);
   Author update(Author author,Long id);

   List<Author> findAll();

}
