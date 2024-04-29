package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemControllers {
    
    @Autowired
    ItemService itemService;

    @PostMapping(produces = "application/json")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item createdItem = itemService.AddItem(item);

        if(createdItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Item>> getAllItems() {
        var items = itemService.GetAllItems();
        if(items == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(items, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public void DeleteItemById(@PathVariable(value = "id") String id) {
        itemService.DeleteItemById(id);
    }
}