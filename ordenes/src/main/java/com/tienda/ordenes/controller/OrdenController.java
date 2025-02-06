package com.tienda.ordenes.controller;

import com.tienda.ordenes.model.Orden;
import com.tienda.ordenes.service.OrdenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
	private final OrdenService ordenService;

	public OrdenController(OrdenService ordenService){
		this.ordenService = ordenService;
	}

	@GetMapping
	public List<Orden> listarOrdenes(){
		return ordenService.obtenerTodas();
	}

	@GetMapping("/usuario/{usuarioId}")
	public List<Orden> listarOrdenesPorUsuario(@PathVariable Long usuarioId){
		return ordenService.obtenerPorUsuario(usuarioId);
	}

	@PostMapping
	public Orden crearOrden(@RequestBody Orden orden){
		return ordenService.crearOrden(orden);
	}

	@DeleteMapping("/{id}")
	public String eliminarOrden(@PathVariable Long id){
		ordenService.eliminarOrden(id);
		return "Orden eliminada con exito";
	}
}
