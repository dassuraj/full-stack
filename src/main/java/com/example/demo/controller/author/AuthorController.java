package com.example.demo.controller.author;

import com.example.demo.dao.AuthorDao;
import com.example.demo.dto.Status;
import com.example.demo.entity.Author;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;


    @GetMapping("")
    public String author(){
        return "author/index";
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Author author){
        boolean status=false;
        String message =null;
        Object data =null;
        try{
            data =authorService.save(author);
            message ="successfully saved";
            status=true;
            Status status1=new Status();
            status1.setData(data);
            status1.setStatus(HttpStatus.ACCEPTED);
            status1.setMessage(message);
            return ResponseEntity.ok(status1);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
