package com.ubisam.demo.domain;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "Phonebook")
@Data
public class Phonebook {
    @Id
    private UUID id;
    private String name;
    private String phoneNumber;
}
