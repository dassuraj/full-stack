package com.example.demo.controller.dem;

import com.example.demo.dto.DemoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/demo")
public class DemoController{

    @GetMapping("")
    public String index(){
        return "/demo/index";
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String address,
            @RequestParam String phoneNumber,
            @RequestParam String description
    ){

            return ResponseEntity.ok(null);
    }
}
