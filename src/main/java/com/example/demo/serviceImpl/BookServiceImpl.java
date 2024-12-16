package com.example.demo.serviceImpl;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;
    @Override
    public Book save(BookDto bookDto) {
        // Validate bookDto fields
        if (bookDto.getAuthors() == null || bookDto.getAuthors().isEmpty()) {
            throw new IllegalArgumentException("Author IDs must not be null or empty");
        }
        if (bookDto.getAuthors().contains(null)) {
            throw new IllegalArgumentException("Author IDs must not contain null values");
        }
        if (bookDto.getCategories() == null || bookDto.getCategories().isEmpty()) {
            throw new IllegalArgumentException("Category IDs must not be null or empty");
        }
        if (bookDto.getCategories().contains(null)) {
            throw new IllegalArgumentException("Category IDs must not contain null values");
        }
        Book book=new Book();
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());
        book.setPublicationYear(bookDto.getPublicationYear());
        book.setPublisher(bookDto.getPublisher());

        List<Author> authors=authorRepository.findAllById(bookDto.getAuthors());
        List<Category> categories=categoryRepository.findAllById(bookDto.getCategories());

        book.setAuthors(authors);
        book.setCategories(categories);

        return bookRepository.save(book);
    }
}
