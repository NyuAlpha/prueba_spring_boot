$(document).ready(function() {
	
	
	cargarPokemon();
  	//$('#dataTable').DataTable();
  
});

async function cargarPokemon(){
	
  // Default options are marked with *
  const response = await fetch("api/pokemon/index", {
    method: "GET", // *GET, POST, PUT, DELETE, etc.
    //mode: "cors", // no-cors, *cors, same-origin
    //cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
    //credentials: "same-origin", // include, *same-origin, omit
    headers: {
      "Content-Type": "application/json",
      // 'Content-Type': 'application/x-www-form-urlencoded',
    },
    //redirect: "follow", // manual, *follow, error
    //referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
    //body: JSON.stringify(data), // body data type must match "Content-Type" header
  });
  //return response.json(); // parses JSON response into native JavaScript objects
	
	const pokemonList = await response.json();
	
	let table = document.querySelector("#pokemon-table");
	
	let pokemonHTML = "";
	
	for(let pokemon of pokemonList){
		
		let deleteButton = "<button onclick = deletePokemon(" + pokemon.number + ")>Eliminar</button>";
		let updateButton = "<button onclick = updatePokemon(" + pokemon.number + ")>Modificar</button>";
		
		pokemonHTML += "<tr> <td>" + pokemon.number + "</td>" +
						"<td>" + pokemon.name + "</td>" +
						"<td>" + pokemon.description + "</td>" +
						"<td>" + pokemon.type + "</td>" + 
						"<td>" + updateButton + "</td>" +
						"<td>" + deleteButton + "</td></tr>";  
	}
	
	table.innerHTML = pokemonHTML;
	
}

async function deletePokemon(number){
	if(confirm("De verdad desea eliminar este pokimon?")){
		  const response = await fetch("api/pokemon/"+number, {
			    method: "DELETE", // *GET, POST, PUT, DELETE, etc.
			    headers: {
			      	"Content-Type": "application/json",
			    },
		  });
		  location.reload();
		  alert("Exito?" + response);
	}
}

function updatePokemon(number){
	window.location.href = '/pokemon-update.html?number=' + number;
}