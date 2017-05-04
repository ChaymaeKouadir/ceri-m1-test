package fr.univavignon.pokedex.imp;

import org.junit.Before;


import fr.univavignon.pokedex.api.IPokedexTest;

public class PokedexTest extends IPokedexTest {

	@Before
	public void setUp() {
		this.p = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
	}

}