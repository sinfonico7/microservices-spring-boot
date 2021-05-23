package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Producto;

public interface ProductoService {

	public List<Producto> findAll();
	
	public Producto findById(Long id);
	
	
}
