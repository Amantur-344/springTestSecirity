package com.example24.demo.service;

import com.example24.demo.entity.Check;
import com.example24.demo.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckRepository checkRepository;
    @Override
    public Check getString(Long id) {
        return checkRepository.getOne(id);
    }


    @Override
    public Check create(Check check) {
        return checkRepository.save(check);
    }
}
