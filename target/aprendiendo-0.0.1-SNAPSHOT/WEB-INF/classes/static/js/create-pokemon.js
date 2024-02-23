async function createPokemon() {
  let datos = {};
  datos.name = document.getElementById('name').value;
  datos.description = document.getElementById('description').value;
  datos.type = document.getElementById('type').value;

  const request = await fetch('api/pokemon', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  alert("Pokemon creado con exito!");
	window.location.href = '/pokemon-lista.html';
}