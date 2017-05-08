package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.*;
import org.mockito.*;

public class IPokemonTrainerFactoryTest {

	@Mock
	protected IPokemonTrainerFactory pokemonTrainerFactory;
	@Mock
	protected PokemonTrainer pokemonTrainer;
	protected String name; 
	protected Team team;
	@Mock
	protected IPokedexFactory pokedexFactory;

	@Before 
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.name = "KOUADIR";
		this.team = Team.MYSTIC;
		Mockito.when(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory)).thenReturn(pokemonTrainer);
		Mockito.when(this.pokemonTrainerFactory.createTrainer(name, team, null)).thenThrow(new Exception());
	}
	
	@Test()
	public void testCreate() throws Exception{
		assertEquals(this.pokemonTrainerFactory.createTrainer(name, team, pokedexFactory),this.pokemonTrainer);
	}

	@Test(expected=Exception.class)
	public void testErreur() throws Exception{
		this.pokemonTrainerFactory.createTrainer(name, team, null);
	}

}
