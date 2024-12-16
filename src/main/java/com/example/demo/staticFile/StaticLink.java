package com.example.demo.staticFile;

import com.example.demo.entity.Author;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class StaticLink {

    public static final List<String> AUTHOR_LIST= Arrays.asList("RAM","SHYAM","LAXMAN");

}
