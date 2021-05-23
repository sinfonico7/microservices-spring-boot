package com.example.demo.models.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.item.Producto;

@FeignClient(name = "servicios-productos")
public interface ProductoClienteRest {

	@GetMapping("/productos")
	public List<Producto> findAll();
	
	@GetMapping(value="/productos/{id}")
	public Producto detalle(@PathVariable Long id);
}
