package com.tienda.usuarios.Controller;

import com.tienda.usuarios.Model.Usuarios;
import com.tienda.usuarios.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    // Endpoint para iniciar sesión
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        String password = request.get("password");

        Usuarios usuarioAutenticado = usuarioService.autenticarUsuario(email, password);

        // Evitar enviar la contraseña en la respuesta
        return Map.of(
                "message", "Inicio de sesión exitoso",
                "id", usuarioAutenticado.getId(),
                "nombre", usuarioAutenticado.getNombre(),
                "email", usuarioAutenticado.getEmail()
        );
    }
}
