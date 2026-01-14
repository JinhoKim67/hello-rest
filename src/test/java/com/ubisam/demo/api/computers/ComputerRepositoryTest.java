package com.ubisam.demo.api.computers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ubisam.demo.domain.Computer;

@SpringBootTest
public class ComputerRepositoryTest {

    @Autowired
    private ComputerRepository computerRepository;

    @Test
    void contextLoads() {

        // Create
        Computer c1 = new Computer();
        c1.setName("window");
        computerRepository.save(c1);

        Computer c2 = new Computer();
        c2.setName("MAC");
        computerRepository.save(c2);

        // Read
        Object findAll = computerRepository.findAll();
        System.out.println("Find All: " + findAll);

        Object findById = computerRepository.findById(c2.getId());
        System.out.println("Find Computer with ID  :"+ c2.getId() + " : " + findById);

        // Update
        c2.setName("Linux");
        Object setName = computerRepository.save(c2);
        System.out.println("Update Computer with ID " + c2.getId() + ": " + setName);

        // Delete
        System.out.println("Delete Computer with ID " + c2.getId() + ": " + setName);
        computerRepository.deleteById(c2.getId());
        Object finalResult = computerRepository.findAll();
        System.out.println("Final Result: " + finalResult);

    }
    
}
