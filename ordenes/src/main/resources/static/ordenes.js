// Manejo del envío del formulario para crear una orden
document.getElementById('formOrden').addEventListener('submit', async (event) => {
    event.preventDefault();

    // Obtener los valores del formulario
    const usuarioId = parseInt(document.getElementById('usuarioId').value);
    const total = parseFloat(document.getElementById('total').value);

    // Convertir el string de IDs de productos a un array de números
    const productosInput = document.getElementById('productos').value;
    const productos = productosInput.split(',').map(id => parseInt(id.trim())).filter(id => !isNaN(id));

    const mensaje = document.getElementById('mensajeOrden');

    try {
        const response = await fetch('http://localhost:8080/ordenes', {

            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ usuarioId, productos, total })
        });

        if (response.ok) {
            mensaje.textContent = 'Orden creada con éxito.';
            mensaje.style.color = 'green';
        } else {
            mensaje.textContent = 'Error al crear la orden.';
            mensaje.style.color = 'red';
        }

        cargarOrdenes();  // Actualiza la lista de órdenes
    } catch (error) {
        mensaje.textContent = 'Error al conectar con el servidor.';
        mensaje.style.color = 'red';
    }
});

// Función para cargar y mostrar las órdenes
async function cargarOrdenes() {
    const listaOrdenes = document.getElementById('listaOrdenes');
    listaOrdenes.innerHTML = ''; // Limpiar la lista actual

    try {
        const response = await fetch('http://localhost:8080/ordenes');

        const ordenes = await response.json();

        ordenes.forEach(orden => {
            const item = document.createElement('li');
            item.textContent = `Orden ID: ${orden.id} | Usuario ID: ${orden.usuarioId} | Total: $${orden.total} | Fecha: ${orden.fecha}`;
            listaOrdenes.appendChild(item);
        });
    } catch (error) {
        listaOrdenes.innerHTML = '<li>Error al cargar las órdenes.</li>';
    }
}
