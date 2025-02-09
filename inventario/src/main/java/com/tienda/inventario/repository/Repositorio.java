package com.tienda.inventario.repository;

import com.tienda.inventario.model.Inventario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface Repositorio extends MongoRepository<Inventario, String> {

	Optional<Inventario> findByProductoId(Long productoId);
}
