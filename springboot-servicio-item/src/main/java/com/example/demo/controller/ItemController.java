package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.item.Item;
import com.example.demo.models.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	//@Qualifier("feignImpl")
	@Qualifier("serviceRestTemplate")
	private ItemService itemService;
	
	@GetMapping("/items")
	public List<Item> findAll(){
		return itemService.findAll();
	}
	
	@GetMapping(value="/items/{id}/cantidad/{cantidad}")
	public Item findById(@PathVariable Long id, @PathVariable Integer cantidad ) {
		return itemService.findById(id, cantidad);
	}
	
}
