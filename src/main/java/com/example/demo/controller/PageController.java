package com.example.demo.controller;

import com.example.demo.dto.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request-from")
public class PageController {


    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping
    public ResponseEntity<?> getData(
            @RequestBody FormData formData
    ) {
        Status status = new Status();
        System.out.println(formData.getName() +"\n"+formData.getEmail() +"\n" +formData.getPhoneNumber());
        status.setData(formData.getPhoneNumber());
        status.setMessage("formData ");
        status.setStatus(HttpStatus.ACCEPTED);
        System.out.println(status);
        return ResponseEntity.ok(status);
    }

    @Setter
    @Getter
    public static class FormData {
        private String name, email, phoneNumber;
    }
}
