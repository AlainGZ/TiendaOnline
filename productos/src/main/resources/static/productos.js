document.getElementById('formProducto').addEventListener('submit', async (event) => {
    event.preventDefault();

    const nombre = document.getElementById('nombre').value;
    const precio = parseFloat(document.getElementById('precio').value);
    const stock = parseInt(document.getElementById('stock').value);
    const descripcion = document.getElementById('descripcion').value;
    const mensaje = document.getElementById('mensaje');

    try {
        const response = await fetch('http://localhost:8081/productos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre, precio, stock, descripcion })
        });

        if (response.ok) {
            mensaje.textContent = 'Producto registrado con éxito.';
            mensaje.style.color = 'green';
        } else {
            mensaje.textContent = 'Error al registrar el producto.';
            mensaje.style.color = 'red';
        }

        cargarProductos();  // Recargar la lista de productos
    } catch (error) {
        mensaje.textContent = 'Error al conectar con el servidor.';
        mensaje.style.color = 'red';
    }
});

async function cargarProductos() {
    const listaProductos = document.getElementById('listaProductos');
    listaProductos.innerHTML = '';  // Limpiar la lista

    try {
        const response = await fetch('http://localhost:8081/productos');
        const productos = await response.json();

        productos.forEach(producto => {
            const item = document.createElement('li');
            item.textContent = `${producto.nombre} - $${producto.precio} (Stock: ${producto.stock})`;
            listaProductos.appendChild(item);
        });
    } catch (error) {
        listaProductos.innerHTML = '<li>Error al cargar los productos.</li>';
    }
}