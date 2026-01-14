package com.ubisam.demo.api.items;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ubisam.demo.domain.Item;

@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void contextLoads() {

        // Create
        Item i1 = new Item();
        i1.setName("Mouse");
        itemRepository.save(i1);

        Item i2 = new Item();
        i2.setName("Keyboard");
        itemRepository.save(i2);


        // Read
        Object findAll = itemRepository.findAll();
        System.out.println("Find All: " + findAll);

        Object findById = itemRepository.findById(i2.getId());
        System.out.println("Find Item with ID  :"+ i2.getId() + " : " + findById);

        // Update
        i2.setName("Monitor");
        Object setName = itemRepository.save(i2);
        System.out.println("Update Item with ID " + i2.getId() + ": " + setName);

        // Delete
        System.out.println("Delete Item with ID " + i2.getId() + ": " + setName);
        itemRepository.deleteById(i2.getId());
        Object finalResult = itemRepository.findAll();
        System.out.println("Final Result: " + finalResult);
        
    }
    
}
