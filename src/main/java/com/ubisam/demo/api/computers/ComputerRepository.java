package com.ubisam.demo.api.computers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubisam.demo.domain.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
}
