package com.tienda.pagos.service;

import com.tienda.pagos.model.Pagos;
import com.tienda.pagos.repository.PagosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PagosService {
	private final PagosRepository pagosRepository;

	public PagosService(PagosRepository pagosRepository){
		this.pagosRepository = pagosRepository;
	}

	//metodo para traer_todo
	public List<Pagos> obtenerTodos(){
		return pagosRepository.findAll();
	}

	//metodo para buscar por el id
	public Optional<Pagos> obtenerPorId(Long id){
		return pagosRepository.findById(id);
	}

	//metodo para buscar por el ordenId
	public List<Pagos> obtenerPorOrdenId(Long ordenId){
		return pagosRepository.findAllById(ordenId);
	}

	//metodo  para crear un pago
	public Pagos crearPago(Pagos pago){
		return pagosRepository.save(pago);
	}

	//metodo para actualizar un pago
	public Pagos actualizarPago(Long id, Pagos pagosActualizado){
		return pagosRepository.findById(id)
				.map(pagos -> {
					pagos.setEstado(pagosActualizado.getEstado());
					pagos.setMonto(pagosActualizado.getMonto());
					pagos.setMetodo(pagosActualizado.getMetodo());
					pagos.setReferencia(pagosActualizado.getReferencia());
					pagos.setOrdenId(pagosActualizado.getOrdenId());
					pagos.setFechaPago(pagosActualizado.getFechaPago());
				return pagosRepository.save(pagos);
		}).orElseThrow(() -> new RuntimeException("Error al actualizar el pago"));

	}
	//metodo para eliminar un pago
	public void eliminarPago(Long id){
		pagosRepository.deleteById(id);
	}
}
