$(document).ready(function(){
	const urlParams = new URLSearchParams(window.location.search);
	const number = urlParams.get('number'); // Obtiene el número del Pokémon de la URL

	cargarPokemon(number)
});



async function updatePokemon(number) {
  	let datos = {};
  	datos.number = number;
  	datos.name = document.getElementById('name').value;
  	datos.description = document.getElementById('description').value;
  	datos.type = document.getElementById('type').value;

  	const request = await fetch('api/pokemon', {
    	method: 'PUT',
    	headers: {
     	 'Accept': 'application/json',
     	 'Content-Type': 'application/json'
    	},
   		body: JSON.stringify(datos)
  	});
  	alert("Pokemon modificado con exito!");
	window.location.href = '/pokemon-lista.html';
}


async function cargarPokemon(number){
	

  const response = await fetch("api/pokemon/"+ number, {
    method: "GET", // *GET, POST, PUT, DELETE, etc.
    headers: {
      "Content-Type": "application/json",
    },
  });

	
	const pokemon = await response.json();
	
	document.querySelector("#number").value = pokemon.number;
	document.querySelector("#name").value = pokemon.name;
	document.querySelector("#description").textContent = pokemon.description;
	document.querySelector("#type").value = pokemon.type;
	
	document.querySelector("#button-container").innerHTML = "<button type='button' onclick='updatePokemon("+pokemon.number+")'>Modificar</button>"
	
}