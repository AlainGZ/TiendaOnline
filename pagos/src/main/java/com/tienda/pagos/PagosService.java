package com.tienda.pagos;

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

	//metodo  para crear un pago

	//metodo para actualizar un pago

	//metodo para eliminar un pago
}
