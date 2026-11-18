package com.example.tourist.controller;

import com.example.tourist.model.Tourist;
import com.example.tourist.repository.TouristRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {
    private final TouristRepository repository;
    public TouristController(TouristRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Tourist> getAllTourists() {
        return repository.findAll();
    }
}
