package com.example.demo.controller;

import com.example.demo.dto.PeopleDto;
import com.example.demo.dto.Status;
import com.example.demo.model.People;
import com.example.demo.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/people")
public class PeopleController {
   private final PeopleService peopleService;

@GetMapping(value = "/index")
   public String get(){
       return "index";
   }


    @GetMapping(value = "")
    public String page() {
        return "/new/new";
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody People people) {
        peopleService.save(people);
        System.out.println(people.getName());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(people);
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){
        return null;
    }
}
