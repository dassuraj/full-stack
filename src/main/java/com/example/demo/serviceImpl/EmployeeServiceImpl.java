package com.example.demo.serviceImpl;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;


    @Override
    public Employee save(EmployeeDto employeeDto) {

        Employee employee=new Employee();
        employee.setName(employeeDto.getName());
        employee.setDepartment(employeeDto.getDepartment());
        boolean flag=addressRepository.existsById(employeeDto.getAddressId());
        Address address=new Address();
        if (flag){
             address=addressRepository.findById(employeeDto.getAddressId())
                    .orElseThrow(() -> new RuntimeException("Address not found"));
            employee.setAddress(address);

        }else {
            address.setId(employeeDto.getAddressId());
        }
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
