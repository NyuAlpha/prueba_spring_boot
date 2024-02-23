package com.aprendiendoSB.aprendiendo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aprendiendoSB.aprendiendo.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<User> getUsuarios() {
		String query = "FROM User";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		User userRemove = entityManager.find(User.class,id);
		entityManager.remove(userRemove);
	}
	
	@Override
	@Transactional
	public void create(User user) {
		
		entityManager.merge(user);
	}

}
