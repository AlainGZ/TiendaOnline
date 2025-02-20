// Manejar el envío del formulario para crear un envío
document.getElementById('formEnvio').addEventListener('submit', async (event) => {
    event.preventDefault();


    const ordenId = parseInt(document.getElementById('ordenId').value);
    const estado = document.getElementById('estado').value;
    const trackingNumber = document.getElementById('trackingNumber').value;
    const mensajeEnvio = document.getElementById('mensajeEnvio');

    try {
        const response = await fetch('http://localhost:8080/envios', {

            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ ordenId, estado, trackingNumber })
        });

        if (response.ok) {
            mensajeEnvio.textContent = 'Envío creado con éxito.';
            mensajeEnvio.style.color = 'green';
        } else {
            mensajeEnvio.textContent = 'Error al crear el envío.';
            mensajeEnvio.style.color = 'red';
        }
        cargarEnvios();
    } catch (error) {
        mensajeEnvio.textContent = 'Error al conectar con el servidor.';
        mensajeEnvio.style.color = 'red';
    }
});


async function cargarEnvios() {
    const listaEnvios = document.getElementById('listaEnvios');
    listaEnvios.innerHTML = '';

    try {
        const response = await fetch('http://localhost:8080/envios');

        const envios = await response.json();

        envios.forEach(envio => {
            const li = document.createElement('li');
            li.textContent = `ID: ${envio.id} | Orden: ${envio.ordenId} | Estado: ${envio.estado} | Tracking: ${envio.trackingNumber} | Fecha: ${envio.fechaEnvio}`;
            listaEnvios.appendChild(li);
        });
    } catch (error) {
        listaEnvios.innerHTML = '<li>Error al cargar los envíos.</li>';
    }
}
