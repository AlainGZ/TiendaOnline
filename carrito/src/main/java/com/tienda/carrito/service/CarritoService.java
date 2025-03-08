package com.tienda.carrito.service;

import com.tienda.carrito.repository.CarritoRepository;
import org.springframework.stereotype.Service;

@Service
public class CarritoService {
	private final CarritoRepository carritoRepository;

	public CarritoService(CarritoRepository carritoRepository){
		this.carritoRepository = carritoRepository;
	}



}
