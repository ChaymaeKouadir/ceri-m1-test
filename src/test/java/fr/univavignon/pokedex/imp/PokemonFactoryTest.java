package fr.univavignon.pokedex.imp;

import org.junit.Before;

import fr.univavignon.pokedex.api.IPokemonFactoryTest;
import fr.univavignon.pokedex.api.Pokemon;;


public class PokemonFactoryTest extends IPokemonFactoryTest{
	
	@Before
	public void setUp() {
		this.p1 = new Pokemon(0,"Bulbasaur",126,126,90,613,64,4000,4,0);
		this.pF = new PokemonFactory();
		
	}
}
