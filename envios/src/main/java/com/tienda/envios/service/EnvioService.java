package com.tienda.envios.service;

import com.tienda.envios.model.Envio;
import com.tienda.envios.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService {
	private final EnvioRepository envioRepository;

	public EnvioService(EnvioRepository envioRepository){
		this.envioRepository = envioRepository;
	}
	public List<Envio> obtenerTodos() {
		return envioRepository.findAll();
	}
	public List<Envio> obtenerPorOrdenId(Long ordenId) {
		return envioRepository.findByOrdenId(ordenId);
	}
	public Optional<Envio> obtenerPorId(Long id) {
		return envioRepository.findById(id);
	}
	public Envio crearEnvio(Envio envio){
		envio.setFechaEnvio(LocalDateTime.now());
		return envioRepository.save(envio);
	}

	public Envio actualizarEnvio(Long id, Envio envioActualizado) {
		return envioRepository.findById(id).map(envio -> {
			envio.setOrdenId(envioActualizado.getOrdenId());
			envio.setEstado(envioActualizado.getEstado());
			envio.setTrackingNumber(envioActualizado.getTrackingNumber());

			return envioRepository.save(envio);
		}).orElseThrow(() -> new RuntimeException("Envío no encontrado"));
	}
	public void eliminarEnvio(Long id){
		envioRepository.deleteById(id);
	}
}
