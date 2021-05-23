package com.example.demo.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.item.Item;
import com.example.demo.models.item.Producto;
@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService{

	@Autowired
	private RestTemplate clienteTemplate;
	
	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList(clienteTemplate.getForObject("http://servicios-productos/productos", Producto[].class)); 
				return productos.stream().map(producto -> new Item(producto,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id,int cantidad) {
		
		Map<String,String> params = new HashMap<>();
		params.put("id", id.toString());
		Producto producto = clienteTemplate.getForObject("http://servicios-productos/productos/{id}", Producto.class,params);
		return new Item(producto,cantidad);
	}

}
