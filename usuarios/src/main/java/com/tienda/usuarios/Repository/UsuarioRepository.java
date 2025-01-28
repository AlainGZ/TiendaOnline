package com.tienda.usuarios.Repository;

import com.tienda.usuarios.Model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
}
