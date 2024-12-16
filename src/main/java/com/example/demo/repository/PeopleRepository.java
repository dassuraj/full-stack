package com.example.demo.repository;

import com.example.demo.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People,Long> {
    @Query("select p.name,p.email,p.address,p.country,p.phoneNumber from People p")
    List<People>  selectAll();
}
