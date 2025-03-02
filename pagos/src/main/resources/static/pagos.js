const baseUrl = 'http://localhost:8080/pagos';

//  cargar pagos por ordenId
async function cargarPagos(filterOrdenId = null) {
    const pagosList = document.getElementById('pagosList');
    pagosList.innerHTML = ''; // Limpiar lista

    let url = baseUrl;
    if (filterOrdenId) {
        url += `/orden/${filterOrdenId}`;
    }

    try {
        const response = await fetch(url);
        const pagos = await response.json();
        pagos.forEach(pago => {
            const divItem = document.createElement('div');
            divItem.className = 'pago-item';
            divItem.innerHTML = `
                <div>
                    <strong>ID:</strong> ${pago.id} |
                    <strong>Orden:</strong> ${pago.ordenId} |
                    <strong>Monto:</strong> $${pago.monto} |
                    <strong>Método:</strong> ${pago.metodo} |
                    <strong>Estado:</strong> ${pago.estado} |
                    <strong>Referencia:</strong> ${pago.referencia} |
                    <strong>Fecha Pago:</strong> ${pago.fechaPago ? new Date(pago.fechaPago).toLocaleString() : 'N/A'}
                </div>
                <div class="pago-actions">
                    <button onclick="editarPago(${pago.id})">Editar</button>
                    <button onclick="eliminarPago(${pago.id})">Eliminar</button>
                </div>
            `;
            pagosList.appendChild(divItem);
        });
    } catch (error) {
        pagosList.innerHTML = '<p>Error al cargar los pagos.</p>';
    }
}

// crear o actualizar un pago
document.getElementById('pagoForm').addEventListener('submit', async (event) => {
    event.preventDefault();

    const pagoId = document.getElementById('pagoId').value;
    const ordenId = parseInt(document.getElementById('ordenId').value);
    const monto = parseFloat(document.getElementById('monto').value);
    const metodo = document.getElementById('metodo').value;
    const estado = document.getElementById('estado').value;
    const referencia = parseInt(document.getElementById('referencia').value);
    const mensajePago = document.getElementById('mensajePago');

    const pagoData = { ordenId, monto, metodo, estado, referencia };

    try {
        let response;
        if (pagoId) {
            // Actualizar pago existente
            response = await fetch(`${baseUrl}/${pagoId}`, {
                method: 'PUT',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(pagoData)
            });
        } else {
            // Crear nuevo pago
            response = await fetch(baseUrl, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(pagoData)
            });
        }

        if (response.ok) {
            mensajePago.textContent = pagoId ? 'Pago actualizado correctamente.' : 'Pago creado con éxito.';
            mensajePago.style.color = 'green';
            document.getElementById('pagoForm').reset();
            document.getElementById('pagoId').value = '';
            document.getElementById('btnSubmit').textContent = 'Crear Pago';
            document.getElementById('btnCancel').style.display = 'none';
            cargarPagos();
        } else {
            mensajePago.textContent = 'Error en la operación.';
            mensajePago.style.color = 'red';
        }
    } catch (error) {
        mensajePago.textContent = 'Error al conectar con el servidor.';
        mensajePago.style.color = 'red';
    }
});

// eliminar un pago
async function eliminarPago(id) {
    if (confirm('¿Estás seguro de eliminar este pago?')) {
        try {
            const response = await fetch(`${baseUrl}/${id}`, { method: 'DELETE' });
            if (response.ok) {
                cargarPagos();
            } else {
                alert('Error al eliminar el pago.');
            }
        } catch (error) {
            alert('Error al conectar con el servidor.');
        }
    }
}

// editar un pago: carga los datos en el formulario
async function editarPago(id) {
    try {
        const response = await fetch(`${baseUrl}/${id}`);
        if (response.ok) {
            const pago = await response.json();
            document.getElementById('pagoId').value = pago.id;
            document.getElementById('ordenId').value = pago.ordenId;
            document.getElementById('monto').value = pago.monto;
            document.getElementById('metodo').value = pago.metodo;
            document.getElementById('estado').value = pago.estado;
            document.getElementById('referencia').value = pago.referencia;
            document.getElementById('btnSubmit').textContent = 'Actualizar Pago';
            document.getElementById('btnCancel').style.display = 'inline-block';
        } else {
            alert('Error al obtener los datos del pago.');
        }
    } catch (error) {
        alert('Error al conectar con el servidor.');
    }
}

// cancelar la edición y reiniciar el formulario
document.getElementById('btnCancel').addEventListener('click', () => {
    document.getElementById('pagoForm').reset();
    document.getElementById('pagoId').value = '';
    document.getElementById('btnSubmit').textContent = 'Crear Pago';
    document.getElementById('btnCancel').style.display = 'none';
});

// Filtrar pagos por ID de orden
document.getElementById('btnFilter').addEventListener('click', () => {
    const filterOrdenId = document.getElementById('filterOrdenId').value;
    if (filterOrdenId) {
        cargarPagos(filterOrdenId);
    } else {
        alert('Introduce un ID de Orden para filtrar.');
    }
});

// Limpiar filtro y cargar todos los pagos
document.getElementById('btnClearFilter').addEventListener('click', () => {
    document.getElementById('filterOrdenId').value = '';
    cargarPagos();
});

// Cargar todos los pagos al presionar el botón
document.getElementById('btnCargarPagos').addEventListener('click', () => {
    cargarPagos();
});

// Cargar los pagos al iniciar la página
window.onload = () => {
    cargarPagos();
};
