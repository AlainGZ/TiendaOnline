package com.tienda.inventario.service;

import com.tienda.inventario.repository.InventarioRepository;
import org.springframework.stereotype.Service;

@Service
public class InventarioService {

	private final InventarioRepository inventarioRepository;

	public InventarioService(InventarioRepository inventarioRepository) {
		this.inventarioRepository = inventarioRepository;
	}
}
