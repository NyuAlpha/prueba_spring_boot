package com.aprendiendoSB.aprendiendo.dao;

import java.util.List;

import com.aprendiendoSB.aprendiendo.models.User;

public interface UsuarioDao {

	List<User> getUsuarios();

	void delete(Long id);

	void create(User user);
	
}
