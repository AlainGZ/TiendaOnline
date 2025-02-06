package com.tienda.ordenes.repository;

import com.tienda.ordenes.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public class OrdenRepository extends JpaRepository<Orden, Long>{
	List<Orden> findByUsuarioId(Long usuarioId);
}
