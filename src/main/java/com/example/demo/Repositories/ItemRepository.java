package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Models.Item;

public interface ItemRepository extends MongoRepository<Item, String>{

    Item save(Optional<Item> existingItem);
    
    
}