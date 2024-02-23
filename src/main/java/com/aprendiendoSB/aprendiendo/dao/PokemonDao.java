package com.aprendiendoSB.aprendiendo.dao;

import java.util.List;

import com.aprendiendoSB.aprendiendo.models.Pokemon;

public interface PokemonDao {

	public void create(Pokemon pokemon);

	public List<Pokemon> getPokemon();

	public String delete(Long id);

	public Pokemon getPokemon(Long id);

	public String update(Pokemon pokemon);
	
}
