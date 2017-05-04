package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;


public class IPokemonTrainerFactoryTest {

	@Mock private IPokemonTrainerFactory pokemonTrainerFactory;
	private IPokedex p;
	private IPokedexFactory pF;
	private PokemonTrainer pT = new PokemonTrainer("Trainer", Team.MYSTIC,  p);

	@Before
	public void setUp() throws PokedexException {
		MockitoAnnotations.initMocks(this);
		Mockito.when(pokemonTrainerFactory.createTrainer("Trainer", Team.MYSTIC,  pF)).thenReturn(pT);
	}
	
	@Test
	public void createTrainerTest() {
		assertEquals(pT, pokemonTrainerFactory.createTrainer("Trainer", Team.MYSTIC,  pF));
	}
    
}
