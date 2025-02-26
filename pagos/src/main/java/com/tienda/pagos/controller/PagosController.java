package com.tienda.pagos.controller;

import com.tienda.pagos.model.Pagos;
import com.tienda.pagos.service.PagosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagos")
public class PagosController {
	private final PagosService pagosService;

	public PagosController(PagosService pagosService){
		this.pagosService = pagosService;
	}

	@GetMapping
	public List<Pagos> obtenerTodos(){
		return pagosService.obtenerTodos();
	}

	@GetMapping("/{id}")
	public Pagos obtenerPorId(@PathVariable Long id){
		return pagosService.obtenerPorId(id).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
	}

	@GetMapping("/{ordenId}")
	public List<Pagos> obtenerPorOrdenId(@PathVariable Long ordenId){
		return pagosService.obtenerPorOrdenId(ordenId);
	}

	@PostMapping("/{id}")
	public Pagos crearPago(@RequestBody Pagos pagos){
		return pagosService.crearPago(pagos);
	}

	@PutMapping("/id")
	public Pagos actualizarPago(@PathVariable Long id, @RequestBody Pagos actualizarPago){
		return pagosService.actualizarPago(id, actualizarPago);
	}

	@DeleteMapping("/{id}")
	public String eliminarPago(@PathVariable Long id){
		pagosService.eliminarPago(id);
		return ("Pago Eliminado");
	}

}
