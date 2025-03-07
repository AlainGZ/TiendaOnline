package com.tienda.carrito.repository;

import com.tienda.carrito.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {

	List<Carrito> findAllById(Long id);
}
