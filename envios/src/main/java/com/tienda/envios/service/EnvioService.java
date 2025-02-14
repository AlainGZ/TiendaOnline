package com.tienda.envios.service;

import com.tienda.envios.repository.EnvioRepository;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {
	private final EnvioRepository envioRepository;

	public EnvioService(EnvioRepository envioRepository){
		this.envioRepository = envioRepository;
	}
	


}
