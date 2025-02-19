package com.tienda.envios.controller;

import com.tienda.envios.service.EnvioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/envios")
public class EnvioController {
	private final EnvioService envioService;
	
	public EnvioController(EnvioService envioService){
		this.envioService = envioService;
	}


}
