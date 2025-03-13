package com.tienda.carrito.controller;

import com.tienda.carrito.model.Carrito;
import com.tienda.carrito.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
	private final CarritoService carritoService;

	public CarritoController (CarritoService carritoService){
		this.carritoService = carritoService;
	}

	@GetMapping("/{usuarioId}")
	public Carrito obtenerCarrito(@PathVariable Long usuarioId){
		return carritoService.obntenerOCrearCarrito(usuarioId);
	}

}
