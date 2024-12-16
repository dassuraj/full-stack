package com.example.demo.service;

import com.example.demo.model.People;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PeopleService {
     void save(People people);

     List<People> findAll();
}
