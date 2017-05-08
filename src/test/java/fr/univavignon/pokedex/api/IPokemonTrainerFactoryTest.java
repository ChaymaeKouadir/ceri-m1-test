package fr.univavignon.pokedex.api;

import org.junit.*;
import org.mockito.*;


public class IPokemonTrainerFactoryTest {


	@Mock
	protected IPokemonTrainerFactory ptF;
	
	@Mock
	protected IPokedexFactory pF;
	
	@Mock
	private IPokedex p;
	private Pokemon pok = new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56);
	
	@Before
	public void setUp() throws PokedexException {
			PokemonTrainer pT = new PokemonTrainer("trainer1", Team.INSTINCT, p);
			Mockito.when(ptF.createTrainer("trainer1", Team.INSTINCT, pF)).thenReturn(pT);
			Mockito.when(p.size()).thenReturn(1);
			Mockito.when(p.addPokemon(pok)).thenReturn(0);
			Mockito.when(p.getPokemon(0)).thenReturn(pok);
		
		
	}
	
    
}
