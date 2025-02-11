package com.tienda.inventario.controller;

import com.tienda.inventario.model.Inventario;
import com.tienda.inventario.service.InventarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventarios")
public class InventarioController {

	private final InventarioService inventarioService;

	public InventarioController(InventarioService inventarioService){
		this.inventarioService = inventarioService;
	}

	@GetMapping
	public List<Inventario> listarInventarios() {
		return inventarioService.obtenerTodos();
	}
}
