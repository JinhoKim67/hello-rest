package com.ubisam.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Computer")
@Data
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
}