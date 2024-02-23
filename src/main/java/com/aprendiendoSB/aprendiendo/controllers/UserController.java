package com.aprendiendoSB.aprendiendo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aprendiendoSB.aprendiendo.dao.UsuarioDao;
import com.aprendiendoSB.aprendiendo.models.User;

@RestController
public class UserController {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value="api/usuarios")
	public List<User> prueba() {
		return usuarioDao.getUsuarios();
	}
	
	
	@RequestMapping(value="api/usuarios/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		//@PathVariable = envia la variable de la URL
		usuarioDao.delete(id);
	}
	
	
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody User usuario) {

    	//@RequestBody = convierte el JSON recibido con post al objeto del modelo
        //Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        //String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        //usuario.setPassword(hash);

        usuarioDao.create(usuario);
    }
	
    //Ejemplo
	@RequestMapping(value="usuario/{id}")
	public User user(@PathVariable Long id) {
		User user1 = new User();
		user1.setId(id);
		user1.setName("Manolo");
		user1.setSurname("Gonzalez");
		user1.setTel("6465464353");
		user1.setEmail("manolillo@gmail.com");

		return user1;
	}
	
}
