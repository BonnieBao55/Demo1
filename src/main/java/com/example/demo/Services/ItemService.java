package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    ItemRepository itemRepository;

    public Item AddItem(com.example.demo.Controllers.Item item) {
        Optional<Item> existingItem = itemRepository.findById(item.id);

        try{
            if(existingItem.get() == null) {
                itemRepository.insert(item);
                return itemRepository.save(item);
            } else {
                existingItem.get().quantity += item.quantity;
                return itemRepository.save(existingItem.get());
            }
        } catch(Exception ex) {
            itemRepository.insert(item);
            return itemRepository.save(item);
        }
    }

    public List<Item> GetAllItems() {
        return itemRepository.findAll();
    }

    public void DeleteItemById(String id) {
        itemRepository.deleteById(id);
    }

    public com.example.demo.Controllers.Item AddItem(com.example.demo.Controllers.Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'AddItem'");
    }
}