package com.example.demo.controller;

import com.example.demo.dto.Status;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.Objects;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("")
    public String index(){
        return "demo/index";
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String phoneNumber,
            @RequestParam String description
    ){
        Status status =new Status();
        try {
            Person person = new Person();
            if (Objects.isNull(name) || name.isEmpty() ||
                    Objects.isNull(email) || email.isEmpty()||
                    Objects.isNull(address)||address.isEmpty()||
                    Objects.isNull(description) ||description.isEmpty()
            ){
                return ResponseEntity.badRequest().body("some required field id empty");
            }else {
                person.setName(name);
                person.setEmail(email);
                person.setAddress(address);
                person.setDescription(description);
            }
           if (Objects.isNull(phoneNumber)|| !phoneNumber.isEmpty()){
               try {
                   person.setPhoneNumber(new BigInteger(phoneNumber));
               }catch (NumberFormatException e){
                   ResponseEntity.badRequest().body("Invalid phone number format");
               }
           }
            personService.save(person);
           return ResponseEntity.ok("person saved successfully");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred while saving the person");
        }
    }

}
