package com.example.demo.controller.employee;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.dto.Status;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final AddressRepository addressRepository;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("addresses",addressRepository.findAll());
        return "new/employee";
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EmployeeDto employeeDto){
        try {
            Status status=new Status();
            status.setData(employeeService.save(employeeDto));
            status.setMessage("successfully saved");
            status.setStatus(HttpStatus.ACCEPTED);
            return ResponseEntity.ok(status);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("bad request");
        }

    }
}
