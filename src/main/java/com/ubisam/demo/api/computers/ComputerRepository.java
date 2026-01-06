package com.ubisam.demo.api.computers;

import com.ubisam.demo.domain.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
    List<Computer> findByNameContainingIgnoreCase(String q);
}