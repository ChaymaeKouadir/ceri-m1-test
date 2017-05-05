package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.*;
import org.mockito.*;

public class IPokemonMetadataProviderTest {
	
	@Mock 
	protected IPokemonMetadataProvider ipmp;
	
	private PokemonMetadata pmd1 = new PokemonMetadata(0, "Bulbasaur", 126, 126, 90);
	private PokemonMetadata pmd2 = new PokemonMetadata(133, "Vaporeon", 186, 168, 260);

	
	@Test 
	public void testPokemonMetadata() throws PokedexException{
		
	PokemonMetadata pokemonMetadata = ipmp.getPokemonMetadata(0); 
	assertEquals(126,pokemonMetadata.getAttack());
	assertEquals(126,pokemonMetadata.getDefense());
	assertEquals(0,pokemonMetadata.getIndex());
	assertEquals("Bulbasaur",pokemonMetadata.getName());
	assertEquals(90,pokemonMetadata.getStamina());
	
	}

	@Test(expected = PokedexException.class)
	public void execptionIndex() throws PokedexException, IOException {
		ipmp.getPokemonMetadata(-2);
	}
	@Test(expected = PokedexException.class)
	public void execptionIndexOut() throws PokedexException {
		ipmp.getPokemonMetadata(155);	
	}
	
	@Before
	public void setUp() throws PokedexException {
		
	MockitoAnnotations.initMocks(this);
	Mockito.when(ipmp.getPokemonMetadata(0)).thenReturn(pmd1);
	Mockito.when(ipmp.getPokemonMetadata(133)).thenReturn(pmd2);
	Mockito.when(ipmp.getPokemonMetadata(-2)).thenThrow(new PokedexException("Error : Index doesnt exist "));
	Mockito.when(ipmp.getPokemonMetadata(155)).thenThrow(new PokedexException("Error: Index outOfBounds"));
		
	}
	
}