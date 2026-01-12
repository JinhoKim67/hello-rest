package com.ubisam.demo.api.phonebooks;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ubisam.demo.domain.Phonebook;

public interface PhonebookRepository extends JpaRepository<Phonebook, java.util.UUID> {

    
}
