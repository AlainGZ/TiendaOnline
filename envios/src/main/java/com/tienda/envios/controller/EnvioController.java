package com.tienda.envios.controller;

import com.tienda.envios.model.Envio;
import com.tienda.envios.service.EnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/envios")
public class EnvioController {
	private final EnvioService envioService;

	public EnvioController(EnvioService envioService){
		this.envioService = envioService;
	}

	@GetMapping
	public List<Envio> listarEnvios(){
		return envioService.obtenerTodos();
	}

	@GetMapping("/orden/{ordenId}")
	public List<Envio> listarEnviosPorOrden(@PathVariable Long ordenId){
		return envioService.obtenerPorOrdenId(ordenId);
	}

	@GetMapping("/{id}")
	public Envio obtenerEnvio(@PathVariable Long id){
		return envioService.obtenerPorId(id).
				orElseThrow(() -> new RuntimeException("Envio no encontrado"));
	}

	@PostMapping
	public Envio crearEnvio(@RequestBody Envio envio){
		return envioService.crearEnvio(envio);
	}

	@PutMapping("/{id}")
	public Envio actualizarEnvio(@PathVariable Long id, @RequestBody Envio envioActualizado){
		return envioService.actualizarEnvio(id,envioActualizado);
	}

	@DeleteMapping("/{id}")
	public String eliminarEnvio(@PathVariable Long id){
		envioService.eliminarEnvio(id);
		return ("Envio eliminado exitosamente");
	}
}
