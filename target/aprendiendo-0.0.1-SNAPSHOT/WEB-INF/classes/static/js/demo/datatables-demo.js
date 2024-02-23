// Call the dataTables jQuery plugin
$(document).ready(function() {
	
	
	cargarUsuarios();
  	$('#dataTable').DataTable();
  
});


async function cargarUsuarios(){
	
	 // Opciones por defecto estan marcadas con un *
	 const response = await fetch("api/usuarios", {
	    method: 'GET', // *GET, POST, PUT, DELETE, etc.
	    headers: {
	      'Content-Type': 'application/json'
	      // 'Content-Type': 'application/x-www-form-urlencoded',
	    }
	  });
	  const usuarios = await response.json();
	  
	  
	  let usuarioshtml = '';
	  for(let usuario of usuarios){
		  let deleteButton = '<a href="#" onclick="deleteUser(' +usuario.id+ ')" class="btn btn-danger btn-circle"> <i class="fas fa-trash"></i></a>'
	  	  usuarioshtml += '<tr><td>' + usuario.id + '</td>'
				+ '<td>' + usuario.name + '</td>'
				+ '<td>' + usuario.surname + '</td>'
				+ '<td>' + usuario.email + '</td>'
				+ '<td>' + usuario.tel + '</td>'
				+ '<td> ' + deleteButton + '</td></tr>'
	  }
	  

	  //return response.json(); // parses JSON response into native JavaScript objects
	  
	  document.querySelector("#dataTable tbody").outerHTML = usuarioshtml;
	
}


async function deleteUser(id){
	if(!confirm("¿Desea eliminar este usuario?")){
		return;
	}
	
	const response = await fetch("api/usuarios/" + id, {
	    method: 'DELETE', // *GET, POST, PUT, DELETE, etc.
	    headers: {
	      'Content-Type': 'application/json'
	      // 'Content-Type': 'application/x-www-form-urlencoded',
	    }
	  });
	  
	  location.reload();
	  
	  
}