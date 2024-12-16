package com.example.demo.serviceImpl;

import com.example.demo.model.People;
import com.example.demo.repository.PeopleRepository;
import com.example.demo.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PeopleServiceImpl implements PeopleService {
    private final PeopleRepository peopleRepository;

    @Override
    public void save(People people) {
    peopleRepository.save(people);
    }

    @Override
    public List<People> findAll() {
        return peopleRepository.selectAll();
    }
}
