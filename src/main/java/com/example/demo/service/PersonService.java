package com.example.demo.service;

import com.example.demo.entity.Person;
import org.springframework.stereotype.Service;

@Service
public interface PersonService {

    public Person save(Person person);
}
