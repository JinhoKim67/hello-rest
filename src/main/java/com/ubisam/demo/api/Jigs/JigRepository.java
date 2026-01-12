package com.ubisam.demo.api.Jigs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubisam.demo.domain.Jig;

public interface JigRepository extends JpaRepository<Jig, String> {
  
}