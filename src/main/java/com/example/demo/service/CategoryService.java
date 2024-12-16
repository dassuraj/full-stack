package com.example.demo.service;

import com.example.demo.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    public Category save(Category category);
    public List<Category> findAll();
}
