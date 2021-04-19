package com.example.controller;

import com.example.repository.ApiRepository;
import com.example.entity.ApiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    private ApiRepository apiRepository;

    @PostMapping(value="/addData")
    public <T> ResponseEntity<T> handlePostRequest(@RequestBody ApiData apiData) {

        apiRepository.save(apiData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/getData/{id}")
    public <T> ResponseEntity<T> handleGetRequest(@PathVariable("id") String id) {

        Optional<ApiData> apiData =  apiRepository.findById(id);
        return new ResponseEntity(apiData, HttpStatus.CREATED);
    }
}
