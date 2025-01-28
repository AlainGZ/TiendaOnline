package com.tienda.usuarios.Controller;

import com.tienda.usuarios.Model.Usuarios;
import com.tienda.usuarios.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuarios> obtenerUsuarios() {
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public Usuarios crearUsuario(@RequestBody Usuarios usuarios) {
        return usuarioService.guardarUsuario(usuarios);
    }

}
