package com.tienda.pagos;

import com.tienda.pagos.repository.PagosRepository;
import org.springframework.stereotype.Service;

@Service
public class PagosService {
	private final PagosRepository pagosRepository;

	private PagosService(PagosRepository pagosRepository){
		this.pagosRepository = pagosRepository;
	}
}
