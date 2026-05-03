package com.gedoria.app.service;

import com.gedoria.app.entity.Item;
import com.gedoria.app.exception.ResourceNotFoundException;
import com.gedoria.app.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = getItemById(id);

        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());
        item.setLocation(itemDetails.getLocation());
        item.setAvailable(itemDetails.isAvailable());
        item.setPrice(itemDetails.getPrice());

        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Item item = getItemById(id);
        itemRepository.delete(item);
    }
}
