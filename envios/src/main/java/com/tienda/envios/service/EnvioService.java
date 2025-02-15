package com.tienda.envios.service;

import com.tienda.envios.model.Envio;
import com.tienda.envios.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
	private final EnvioRepository envioRepository;

	public EnvioService(EnvioRepository envioRepository){
		this.envioRepository = envioRepository;
	}
	public List<Envio> obtenerTodos() {
		return envioRepository.findAll();
	}


}
