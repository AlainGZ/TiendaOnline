package com.tienda.usuarios.Service;

import com.tienda.usuarios.Model.Usuarios;
import com.tienda.usuarios.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuarios guardarUsuario(Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }
}
