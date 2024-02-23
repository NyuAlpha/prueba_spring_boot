package com.aprendiendoSB.aprendiendo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aprendiendoSB.aprendiendo.dao.PokemonDao;
import com.aprendiendoSB.aprendiendo.models.Pokemon;

@RestController
public class PokemonController {
	
	@Autowired
	private PokemonDao pokemonDao;

	
	@RequestMapping(value="api/pokemon/index",method = RequestMethod.GET)
	private List<Pokemon> getPokemon(){
		return pokemonDao.getPokemon();
	}
	
	@RequestMapping(value="api/pokemon/{id}",method = RequestMethod.GET)
	private Pokemon getPokemon(@PathVariable Long id){
		return pokemonDao.getPokemon(id);
	}
	
	@RequestMapping(value="api/pokemon",method = RequestMethod.POST)
	public void createPokemon(@RequestBody Pokemon pokemon) {
		pokemonDao.create(pokemon);
	}
	
	@RequestMapping(value="api/pokemon/{id}",method = RequestMethod.DELETE)
	public String deletePokemon(@PathVariable Long id) {
		return pokemonDao.delete(id);
	}
	
	@RequestMapping(value="api/pokemon",method = RequestMethod.PUT)
	public String updatePokemon(@RequestBody Pokemon pokemon) {
		return pokemonDao.update(pokemon);
	}
	
}
