package com.ubisam.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Computer {
    
    @Id
    private Long id;
    private String name;    
}
