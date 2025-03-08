package com.tienda.carrito.service;

import com.tienda.carrito.model.Carrito;
import com.tienda.carrito.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarritoService {
	private final CarritoRepository carritoRepository;

	public CarritoService(CarritoRepository carritoRepository){
		this.carritoRepository = carritoRepository;
	}

	public Carrito ontenerOCrearCarrito(Long usuarioId){
		return carritoRepository.findByUsuarioId(usuarioId)
				.orElseGet(() -> carritoRepository.save(new Carrito(null, usuarioId, new ArrayList<>())));
	}

}
