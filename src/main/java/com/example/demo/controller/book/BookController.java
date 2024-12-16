package com.example.demo.controller.book;

import com.example.demo.dto.BookDto;
import com.example.demo.dto.Status;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.CategoryService;
import com.example.demo.staticFile.StaticLink;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @GetMapping(value = "")
    public String book(Model model){
        model.addAttribute("authors",authorService.findAll());
        model.addAttribute("categories",categoryService.findAll());
        return "book/book";
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveBook(@RequestBody BookDto bookDto) {
        Status status=new Status();
        try{
            Object data=bookService.save(bookDto);
            status.setData(data);
            status.setMessage("successfully data is saved");
            status.setStatus(HttpStatus.ACCEPTED);
            return ResponseEntity.ok(status);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("bad request");
        }
    }
}
