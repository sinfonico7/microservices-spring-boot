package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.item.Item;

public interface ItemService {
	
	public List<Item> findAll();
	
	public Item findById(Long id,int cantidad);
	
}
