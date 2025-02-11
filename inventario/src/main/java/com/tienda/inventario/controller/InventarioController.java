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

	@GetMapping("/{id}")
	public Inventario obtenerInventario(@PathVariable String id){
		return inventarioService.obtenerPorId(id)
				.orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
	}

	@GetMapping("/producto/{productoId}")
	public Inventario obtenerProductoPorId(@PathVariable Long productoId){
		return inventarioService.obtenerPorProductoId(productoId)
				.orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
	}

	@PostMapping
	public Inventario crearInventario(@RequestBody Inventario inventario){
		return inventarioService.guardarInventario(inventario);
	}
	@PutMapping("/{id}")
	public Inventario actualizarInventario(@PathVariable String id, @RequestBody Inventario inventarioActualizado){
		return inventarioService.actualizarInventario(id, inventarioActualizado);
	}

	@DeleteMapping("/{id}")
	public String eliminarInventario(@PathVariable String id){
		inventarioService.eliminarInventario(id);
		return  "Inventario eliminado con exito";
	}

}
