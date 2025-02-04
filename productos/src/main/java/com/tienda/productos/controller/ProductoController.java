package com.tienda.productos.controller;

import com.tienda.productos.model.Producto;  // Importamos la entidad
import com.tienda.productos.service.ProductoService;  // Importamos el servicio
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Aqui define que esta clase es un controlador Rest
@RequestMapping("/productos") // La api esta en /productos
public class ProductoController {
	private final ProductoService productoService;

	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping
	public List<Producto> listarProductos() {
		return productoService.obtenerTodos();
	}

	@GetMapping("/{id}")
	public Optional<Producto> obtenerProducto(@PathVariable Long id) {
		return productoService.obtenerPorId(id);
	}

	@PostMapping
	public Producto crearProducto(@RequestBody Producto producto) {
		return productoService.guardarProducto(producto);
	}

	@PutMapping("/{id}")
	public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
		return productoService.actualizarProducto(id, productoActualizado);
	}

	@DeleteMapping("/{id}")
	public String eliminarProducto(@PathVariable Long id) {
		productoService.eliminarProducto(id);
		return "Producto eliminado con éxito";
	}
}
