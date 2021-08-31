package com.example.security_demo.repository;

import com.example.security_demo.model.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {

}
