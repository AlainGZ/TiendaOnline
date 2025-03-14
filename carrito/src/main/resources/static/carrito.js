
const baseUrl = 'http://localhost:8081/carrito';


document.getElementById('btnVerCarrito').addEventListener('click', async () => {
    const usuarioId = document.getElementById('usuarioId').value;
    const carritoDisplay = document.getElementById('carritoDisplay');
    carritoDisplay.innerHTML = 'Cargando...';

    try {
        const response = await fetch(`${baseUrl}/${usuarioId}`);
        if (response.ok) {
            const carrito = await response.json();
            let html = `<p><strong>ID Carrito:</strong> ${carrito.id}</p>`;
            html += `<p><strong>ID Usuario:</strong> ${carrito.usuarioId}</p>`;
            if (carrito.items && carrito.items.length > 0) {
                html += `<ul>`;
                carrito.items.forEach(item => {
                    html += `<li><strong>Producto:</strong> ${item.productoId} - <strong>Cantidad:</strong> ${item.cantidad}</li>`;
                });
                html += `</ul>`;
            } else {
                html += `<p>El carrito está vacío.</p>`;
            }
            carritoDisplay.innerHTML = html;
        } else {
            carritoDisplay.innerHTML = '<p>Error al cargar el carrito.</p>';
        }
    } catch (error) {
        carritoDisplay.innerHTML = '<p>Error de conexión.</p>';
    }
});


document.getElementById('btnAgregar').addEventListener('click', async () => {
    const usuarioId = document.getElementById('usuarioIdAgregar').value;
    const productoId = document.getElementById('productoId').value;
    const cantidad = document.getElementById('cantidad').value;
    const mensajeAgregar = document.getElementById('mensajeAgregar');

    try {
        const response = await fetch(`${baseUrl}/${usuarioId}/agregar?productoId=${productoId}&cantidad=${cantidad}`, {
            method: 'POST'
        });
        if (response.ok) {
            mensajeAgregar.textContent = 'Producto agregado al carrito.';
            mensajeAgregar.style.color = 'green';
        } else {
            mensajeAgregar.textContent = 'Error al agregar el producto.';
            mensajeAgregar.style.color = 'red';
        }
    } catch (error) {
        mensajeAgregar.textContent = 'Error de conexión.';
        mensajeAgregar.style.color = 'red';
    }
});


document.getElementById('btnEliminar').addEventListener('click', async () => {
    const usuarioId = document.getElementById('usuarioIdEliminar').value;
    const productoId = document.getElementById('productoIdEliminar').value;
    const mensajeEliminar = document.getElementById('mensajeEliminar');

    try {
        const response = await fetch(`${baseUrl}/${usuarioId}/eliminar?productoId=${productoId}`, {
            method: 'DELETE'
        });
        if (response.ok) {
            mensajeEliminar.textContent = 'Producto eliminado del carrito.';
            mensajeEliminar.style.color = 'green';
        } else {
            mensajeEliminar.textContent = 'Error al eliminar el producto.';
            mensajeEliminar.style.color = 'red';
        }
    } catch (error) {
        mensajeEliminar.textContent = 'Error de conexión.';
        mensajeEliminar.style.color = 'red';
    }
});
