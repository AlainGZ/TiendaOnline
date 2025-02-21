const baseUrl = 'http://localhost:8080/envios';

async function cargarEnvios(filterOrdenId = null) {
    const enviosList = document.getElementById('enviosList');
    enviosList.innerHTML = ''; // Limpiar lista

    let url = baseUrl;
    if (filterOrdenId) {
        url += `/orden/${filterOrdenId}`;
    }

    try {
        const response = await fetch(url);
        const envios = await response.json();
        envios.forEach(envio => {
            const divItem = document.createElement('div');
            divItem.className = 'envio-item';
            divItem.innerHTML = `
                <div>
                    <strong>ID:</strong> ${envio.id} |
                    <strong>Orden:</strong> ${envio.ordenId} |
                    <strong>Estado:</strong> ${envio.estado} |
                    <strong>Tracking:</strong> ${envio.trackingNumber} |
                    <strong>Fecha:</strong> ${envio.fechaEnvio ? new Date(envio.fechaEnvio).toLocaleString() : 'N/A'}
                </div>
                <div class="envio-actions">
                    <button onclick="editarEnvio(${envio.id})">Editar</button>
                    <button onclick="eliminarEnvio(${envio.id})">Eliminar</button>
                </div>
            `;
            enviosList.appendChild(divItem);
        });
    } catch (error) {
        enviosList.innerHTML = '<p>Error al cargar los envíos.</p>';
    }
}


document.getElementById('envioForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const envioId = document.getElementById('envioId').value;
    const ordenId = parseInt(document.getElementById('ordenId').value);
    const estado = document.getElementById('estado').value;
    const trackingNumber = document.getElementById('trackingNumber').value;
    const mensajeEnvio = document.getElementById('mensajeEnvio');

    const envioData = { ordenId, estado, trackingNumber };

    try {
        let response;
        if (envioId) {

            response = await fetch(`${baseUrl}/${envioId}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(envioData)
            });
        } else {

            response = await fetch(baseUrl, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(envioData)
            });
        }

        if (response.ok) {
            mensajeEnvio.textContent = envioId ? 'Envío actualizado correctamente.' : 'Envío creado con éxito.';
            mensajeEnvio.style.color = 'green';
            document.getElementById('envioForm').reset();
            document.getElementById('envioId').value = '';
            document.getElementById('btnSubmit').textContent = 'Crear Envío';
            document.getElementById('btnCancel').style.display = 'none';
            cargarEnvios();
        } else {
            mensajeEnvio.textContent = 'Error en la operación.';
            mensajeEnvio.style.color = 'red';
        }
    } catch (error) {
        mensajeEnvio.textContent = 'Error al conectar con el servidor.';
        mensajeEnvio.style.color = 'red';
    }
});


async function eliminarEnvio(id) {
    if (confirm('¿Estás seguro de eliminar este envío?')) {
        try {
            const response = await fetch(`${baseUrl}/${id}`, { method: 'DELETE' });
            if (response.ok) {
                cargarEnvios();
            } else {
                alert('Error al eliminar el envío.');
            }
        } catch (error) {
            alert('Error al conectar con el servidor.');
        }
    }
}


async function editarEnvio(id) {
    try {
        const response = await fetch(`${baseUrl}/${id}`);
        if (response.ok) {
            const envio = await response.json();
            document.getElementById('envioId').value = envio.id;
            document.getElementById('ordenId').value = envio.ordenId;
            document.getElementById('estado').value = envio.estado;
            document.getElementById('trackingNumber').value = envio.trackingNumber;
            document.getElementById('btnSubmit').textContent = 'Actualizar Envío';
            document.getElementById('btnCancel').style.display = 'inline-block';
        } else {
            alert('Error al obtener los datos del envío.');
        }
    } catch (error) {
        alert('Error al conectar con el servidor.');
    }
}


document.getElementById('btnCancel').addEventListener('click', () => {
    document.getElementById('envioForm').reset();
    document.getElementById('envioId').value = '';
    document.getElementById('btnSubmit').textContent = 'Crear Envío';
    document.getElementById('btnCancel').style.display = 'none';
});


document.getElementById('btnFilter').addEventListener('click', () => {
    const filterOrdenId = document.getElementById('filterOrdenId').value;
    if (filterOrdenId) {
        cargarEnvios(filterOrdenId);
    } else {
        alert('Introduce un ID de Orden para filtrar.');
    }
});


document.getElementById('btnClearFilter').addEventListener('click', () => {
    document.getElementById('filterOrdenId').value = '';
    cargarEnvios();
});


document.getElementById('btnCargarEnvios').addEventListener('click', () => {
    cargarEnvios();
});

window.onload = () => {
    cargarEnvios();
};
