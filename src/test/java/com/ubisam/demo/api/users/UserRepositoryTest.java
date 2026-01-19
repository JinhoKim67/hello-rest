package com.ubisam.demo.api.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ubisam.demo.domain.User;

@SpringBootTest
@AutoconfigureMockMvc
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private MockMvc mockMvc;
    @Test
	void contextLoads() {

        // Create
        User u1 = new User();
        u1.setName("Alice");
        userRepository.save(u1);

        User u2 = new User();
        u2.setName("Bob");
        userRepository.save(u2);

        // Read
        Object findAll = userRepository.findAll();
        System.out.println("Find All: " + findAll);

        Object findById = userRepository.findById(u2.getId());
        System.out.println("Find User with ID " + u2.getId() + ": " + findById);
        
        // Update
        u2.setName("Charlie");
        Object setName = userRepository.save(u2);
        System.out.println("Update User with ID " + u2.getId() + ": " + setName);
        
        // Delete
        System.out.println("Delete User with ID " + u2.getId() + ": " + setName);
        userRepository.deleteById(u2.getId());
        Object finalResult = userRepository.findAll();
        System.out.println("Final Result: " + finalResult);
	}

    @Test
    void contextLoads2() throws Exception {

        // perform mock MVC operations
        mockMvc.perform(null)
               .andExpect(null);
    }

}
