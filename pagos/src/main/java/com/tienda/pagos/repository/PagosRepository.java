package com.tienda.pagos.repository;

import com.tienda.pagos.model.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PagosRepository extends JpaRepository<Pagos, Long> {
	List<Pagos> findAllById(Long ordenId);
}
