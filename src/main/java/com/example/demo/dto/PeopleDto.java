package com.example.demo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PeopleDto {
    private String name;
    private String email;
    private String address;
    private String country;
    private String phoneNumber;
}
