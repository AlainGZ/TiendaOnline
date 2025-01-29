package com.tienda.usuarios.Service;

import com.tienda.usuarios.Model.Usuarios;
import com.tienda.usuarios.Repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Usuarios autenticarUsuario(String email, String password) {
        Optional<Usuarios> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }

        Usuarios usuario = usuarioOpt.get();


        return usuario;
    }

}
