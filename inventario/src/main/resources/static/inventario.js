// Función para manejar el envío del formulario y crear un registro de inventario
document.getElementById('formInventario').addEventListener('submit', async (event) => {
    event.preventDefault();

    // Obtener valores del formulario
    const productoId = parseInt(document.getElementById('productoId').value);
    const cantidad = parseInt(document.getElementById('cantidad').value);
    const mensaje = document.getElementById('mensajeInventario');

    try {
        const response = await fetch('http://localhost:8080/inventarios', {

            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ productoId, cantidad })
        });

        if (response.ok) {
            mensaje.textContent = 'Registro de inventario agregado con éxito.';
            mensaje.style.color = 'green';
        } else {
            mensaje.textContent = 'Error al agregar el registro de inventario.';
            mensaje.style.color = 'red';
        }

        cargarInventario();  // Actualiza la lista de inventario
    } catch (error) {
        mensaje.textContent = 'Error al conectar con el servidor.';
        mensaje.style.color = 'red';
    }
});

// Función para cargar y mostrar la lista de registros de inventario
async function cargarInventario() {
    const listaInventario = document.getElementById('listaInventario');
    listaInventario.innerHTML = '';  // Limpiar la lista actual

    try {
        const response = await fetch('http://localhost:8080/inventarios');

        const inventarios = await response.json();

        inventarios.forEach(inventario => {
            const item = document.createElement('li');
            item.textContent = `Inventario ID: ${inventario.id} | Producto ID: ${inventario.productoId} | Cantidad: ${inventario.cantidad}`;
            listaInventario.appendChild(item);
        });
    } catch (error) {
        listaInventario.innerHTML = '<li>Error al cargar el inventario.</li>';
    }
}
