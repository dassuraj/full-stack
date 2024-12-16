package com.example.demo.dao;

import com.example.demo.model.InfirmaryLogType;

import java.util.List;

public interface InfirmaryLogTypeDao {

    List<InfirmaryLogType> selectAllByRequired(Integer id);
}
