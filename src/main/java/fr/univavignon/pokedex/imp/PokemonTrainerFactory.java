package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.*;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {
	private static PokemonTrainerFactory instance;

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		IPokemonMetadataProvider mp = new PokemonMetadataProvider(); 
		IPokemonFactory pf = new PokemonFactory();
		IPokedex pokedex = pokedexFactory.createPokedex(mp, pf);
		PokemonTrainer pT = new PokemonTrainer(name, team, pokedex);
		pokedex.setPokemonTrainer(pT);
		return new PokemonTrainer(name, team, pokedex);
	}
	private PokemonTrainerFactory(){}

	public static PokemonTrainerFactory getInstance(){
		return instance == null?new PokemonTrainerFactory():instance;
	}
}