package com.tienda.carrito.service;

import com.tienda.carrito.model.Carrito;
import com.tienda.carrito.model.ItemCarrito;
import com.tienda.carrito.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarritoService {
	private final CarritoRepository carritoRepository;

	public CarritoService(CarritoRepository carritoRepository){
		this.carritoRepository = carritoRepository;
	}

	public Carrito obntenerOCrearCarrito(Long usuarioId){
		return carritoRepository.findByUsuarioId(usuarioId)
				.orElseGet(() -> carritoRepository.save
						(new Carrito(null, usuarioId, new ArrayList<>())));
	}
	public Carrito agregarProducto(Long usuarioId, Long productoId, int cantidad){
		Carrito carrito = obntenerOCrearCarrito(usuarioId);

		boolean encontrado = false;
		for (ItemCarrito item : carrito.getItems()){
			if (item.getProductoId().equals(productoId)){
				item.setCantidad(item.getCantidad() + cantidad);
				encontrado = true;
				break;
			}
		}

		if(!encontrado){
			ItemCarrito nuevoItem = new ItemCarrito();
			nuevoItem.setProductoId(productoId);
			nuevoItem.setCantidad(cantidad);
			carrito.getItems().add(nuevoItem);
		}
		return carritoRepository.save(carrito);
	}

}
