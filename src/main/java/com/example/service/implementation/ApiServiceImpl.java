package com.example.service.implementation;

import com.example.entity.ApiData;
import com.example.repository.ApiRepository;
import com.example.service.interfaces.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ApiServiceImpl implements ApiService {

    @Autowired
    ApiRepository apiRepository;

    @Override
    public void save(ApiData apiData) {
        apiRepository.save(apiData);
    }
}
