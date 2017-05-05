package fr.univavignon.pokedex.imp;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;;


public class PokemonFactoryTest extends IPokemonFactoryTest{
	
	@Before
	public void setUp() {
		
		this.pF = new PokemonFactory();
		
	}
}
