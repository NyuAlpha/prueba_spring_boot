package com.aprendiendoSB.aprendiendo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aprendiendoSB.aprendiendo.models.Pokemon;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class PokemonDaoImp implements PokemonDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Pokemon pokemon) {
		entityManager.merge(pokemon);
	}

	@Override
	public List<Pokemon> getPokemon() {
		return entityManager.createQuery("FROM Pokemon").getResultList();
	}
	
	@Override
	public Pokemon getPokemon(Long id) {
	    return entityManager.createQuery("FROM Pokemon WHERE id = :id", Pokemon.class)
	                        .setParameter("id", id)
	                        .getSingleResult();
	}


	@Override
	public String delete(Long id) {
		Pokemon pokemon = entityManager.find(Pokemon.class, id);
		entityManager.remove(pokemon);
		return "Se borro correctamente";
	}

	@Override
	public String update(Pokemon pokemon) {
		entityManager.merge(pokemon);
		return "Se actualizó correctamente";
	}

}
