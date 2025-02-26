package com.tienda.pagos.controller;

import com.tienda.pagos.model.Pagos;
import com.tienda.pagos.service.PagosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PagosController {
	private final PagosService pagosService;

	public PagosController(PagosService pagosService){
		this.pagosService = pagosService;
	}

	@GetMapping
	public List<Pagos> obtenerTodos(){
		return pagosService.obtenerTodos();
	}

	@GetMapping("/id")
	public Optional<Pagos> obtenerPorId(Long id){
		return pagosService.obtenerPorId(id);
	}

	@GetMapping("/ordenId")
	public List<Pagos> obtenerPorOrdenId(Long ordenId){
		return pagosService.obtenerPorOrdenId(ordenId);
	}

}
