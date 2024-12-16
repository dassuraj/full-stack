package com.example.demo.controller.category;

import com.example.demo.dto.Status;
import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("")
    public String category(){
        return "category/index";
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Category category) {
        Status status = new Status();
        try {
            Object data = categoryService.save(category);
            status.setData(data);
            status.setStatus(HttpStatus.ACCEPTED);
            status.setMessage("successfully saved");
            return ResponseEntity.ok(status);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

