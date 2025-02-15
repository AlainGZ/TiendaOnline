package com.tienda.envios.repository;

import com.tienda.envios.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnvioRepository extends JpaRepository<Envio, Long>{

	List<Envio> findByOrdenId(Long ordenId);
}
