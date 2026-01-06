package com.ubisam.demo.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "`User`") // 테이블명이 User면 백틱 처리 권장
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
}