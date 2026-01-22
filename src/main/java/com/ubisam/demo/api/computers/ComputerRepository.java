package com.ubisam.demo.api.computers;

import com.ubisam.demo.domain.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
public interface ComputerRepository extends JpaRepository<Computer, Long> {
    List<Computer> findByNameContainingIgnoreCase(String q);
}