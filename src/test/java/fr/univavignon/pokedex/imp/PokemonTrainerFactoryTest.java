package fr.univavignon.pokedex.imp;

import org.junit.Before;

import fr.univavignon.pokedex.api.*;

public class PokemonTrainerFactoryTest extends IPokemonTrainerFactoryTest {
	@Before 
	public void setUp() throws Exception 
	{ 
		this.pokemonTrainerFactory = PokemonTrainerFactory.getInstance(); 
		this.name = "KOUADIR";
		this.team = Team.MYSTIC;
		this.pokedexFactory = new PokedexFactory();
		this.pokemonTrainer = pokemonTrainerFactory.createTrainer(name,team,this.pokedexFactory);
	}

}
