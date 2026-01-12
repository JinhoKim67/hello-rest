package com.ubisam.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Item")
@Data
public class Jig {
    @Id
    private String id;
    private Integer jigNumber;
    private String description;
}
