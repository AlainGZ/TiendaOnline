package com.tienda.productos.service;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    // Constructor que inyecta el repositorio en el servicio
    public ProductoService(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }

    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado){
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            producto.setDescripcion(productoActualizado.getDescripcion());
            return productoRepository.save(producto);
        }).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
    
    public void eliminarProducto(Long id){
        productoRepository.deleteById(id);
    }
}
