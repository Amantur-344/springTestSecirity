package com.example24.demo.service;

import com.example24.demo.entity.Check;

public interface CheckService {
    Check getString(Long id);
    Check create (Check check);
}
