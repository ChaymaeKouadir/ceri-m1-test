package fr.univavignon.pokedex.imp;

import org.junit.Before;
import fr.univavignon.pokedex.api.IPokedexTest;
import fr.univavignon.pokedex.api.Pokemon;

public class PokedexTest extends IPokedexTest {

	@Before
	public void setUp() {
		this.p = new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
		this.p1 = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
	}

}