package com.tienda.usuarios.Repository;

import com.tienda.usuarios.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    Optional<Usuarios> findByEmail(String email);
}
