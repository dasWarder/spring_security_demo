package com.example.security_demo.controller;


import com.example.security_demo.model.Developer;
import com.example.security_demo.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/developers")
public class DeveloperControllerV1 {

    private final DeveloperRepository developerRepository;

    @GetMapping
    public ResponseEntity<List<Developer>> getAllDevelopers() {
        log.info("Get a list of all developers");

        List<Developer> response = (List<Developer>) developerRepository.findAll();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable("id") Long id) {
        log.info("Get a developer by id = {}", id);

        Developer developer = developerRepository.findById(id)
                                                            .orElseThrow(IllegalArgumentException::new);

        return ResponseEntity.ok(developer);
    }

    @PostMapping
    public ResponseEntity<Developer> saveDeveloper(@RequestBody Developer developer) {
        log.info("Save a new developer");

        Developer storedDeveloper = developerRepository.save(developer);

        return ResponseEntity
                            .created(URI.create("http://localhost:8080/api/v1/developers"))
                            .body(storedDeveloper);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloperById(@PathVariable("id") Long id) {
        log.info("Devete a developer by id = {}", id);

        developerRepository.deleteById(id);

        return ResponseEntity
                            .noContent()
                            .build();
    }
}
