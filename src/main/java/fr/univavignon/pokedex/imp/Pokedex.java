package fr.univavignon.pokedex.imp;

import java.io.Serializable;
import java.util.*;
import fr.univavignon.pokedex.api.*;

public class Pokedex implements IPokedex, Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4676586567250936637L;
	private IPokemonMetadataProvider pmp; 	
	private IPokemonFactory pF;
	private Map<Integer,Pokemon> pMap; 
	private PokemonTrainer pT;
	
	public Pokedex(IPokemonMetadataProvider pmp, IPokemonFactory pF) {
		super();
		this.pmp = pmp;
		this.pF = pF;
		this.pMap = new LinkedHashMap<Integer,Pokemon>();
	}
	
	@Override
	public int size() {
		return pMap.size();
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		if(!pMap.containsKey(id))
			throw new PokedexException("The Pokemon is unavailable");
		else 
			return pMap.get(id);
		
	}
	
	@Override
	public int addPokemon(Pokemon pokemon) {
		Integer place = size();
		pMap.put(size(), pokemon);
		notifyPokemonTrainer();
		return place;
	}



	@Override
	public List<Pokemon> getPokemons() {
	    List<Pokemon> pokemons = new ArrayList<>(pMap.values());
		return pokemons;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		List<Pokemon> pokemons = new ArrayList<>(pMap.values());
		Collections.sort(pokemons, order);
		return pokemons;
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		return pmp.getPokemonMetadata(index);
	}
	
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		return pF.createPokemon(index, cp, hp, dust, candy);
	}

	@Override
	public void setPokemonTrainer(PokemonTrainer pT) {
		this.pT = pT;
	}

	@Override
	public void notifyPokemonTrainer() {

		if(pT != null) pT.saveAsFile();
	}


}