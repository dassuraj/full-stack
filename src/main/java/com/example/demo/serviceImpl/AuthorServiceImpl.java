package com.example.demo.serviceImpl;

import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;


    @Override
    public Author save(Author author) {
     return authorRepository.save(author);
    }

    @Override
    public Author update(Author author, Long id) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

}
