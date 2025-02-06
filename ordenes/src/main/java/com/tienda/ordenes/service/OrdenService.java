package com.tienda.ordenes.service;

import com.tienda.ordenes.model.Orden;
import com.tienda.ordenes.repository.OrdenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrdenService {
	private final OrdenRepository ordenRepository;

	public OrdenService(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}

	public List<Orden> obtenerTodas() {
		return ordenRepository.findAll();
	}

	public List<Orden> obtenerPorUsuario(Long usuarioId) {
		return ordenRepository.findByUsuarioId(usuarioId);
	}

	public Orden crearOrden(Orden orden) {
		orden.setFecha(LocalDateTime.now());
		return ordenRepository.save(orden);
	}

	public void eliminarOrden(Long id) {
		ordenRepository.deleteById(id);
	}
}
