package com.example.demo.daoimpl;

import com.example.demo.dao.InfirmaryLogTypeDao;
import com.example.demo.model.InfirmaryLogType;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class InfirmaryLogTypeDaoImpl implements InfirmaryLogTypeDao {
    @Override
    public List<InfirmaryLogType> selectAllByRequired(Integer id) {
        return List.of();
    }
}
