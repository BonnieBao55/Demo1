package com.example.demo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("restaurants")
public class Restaurant {
    String borough;
    String cuisine;
    String name;
    @Id
    String restaurant_id;

    // public Restaurant(String borough, 
    //         String cuisine, String name, String restaurant_id) {
    //     borough = this.borough;
    //     cuisine = this.cuisine;
    //     name = this.name;
    //     restaurant_id = this.restaurant_id;
    //}
}
