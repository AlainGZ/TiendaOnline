package com.tienda.inventario.service;

import com.tienda.inventario.model.Inventario;
import com.tienda.inventario.repository.InventarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

	private final InventarioRepository inventarioRepository;

	public InventarioService(InventarioRepository inventarioRepository) {
		this.inventarioRepository = inventarioRepository;
	}

	public List<Inventario> obtenerTodos(){
		return inventarioRepository.findAll();
	}

	public Optional<Inventario> obtenerPorId(String id){
		return inventarioRepository.findById(id);
	}

	public Optional<Inventario> obtenerPorProductoId(Long productoId){
		return inventarioRepository.findByProductoId(productoId);
	}

	public Inventario guardarInventario(Inventario inventario){
		return inventarioRepository.save(inventario);
	}

	public Inventario actualizarInventario(String id, Inventario inventarioActualizado) {
		return inventarioRepository.findById(id)
				.map(inventario -> {
					inventario.setProductoId(inventarioActualizado.getProductoId());
					inventario.setCantidad(inventarioActualizado.getCantidad());
					return inventarioRepository.save(inventario);
				}).orElseThrow(() -> new RuntimeException("Inventario no encontrado"));
	}

	public void eliminarInventario(String id){
		inventarioRepository.deleteById(id);
	}

}
