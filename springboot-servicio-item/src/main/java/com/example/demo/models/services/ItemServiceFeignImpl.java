package com.example.demo.models.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.item.Item;
@Service("feignImpl")
//@Primary // to avoid qualifier
public class ItemServiceFeignImpl implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
	
		return clienteFeign.findAll().stream().map(producto -> new Item(producto,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, int cantidad) {
		
		return new Item(clienteFeign.detalle(id), cantidad) ;
	}

}
