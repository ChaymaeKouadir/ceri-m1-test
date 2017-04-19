package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.mockito.*;

public final class IPokemonMetadataProviderTest {
	
	@Mock private IPokemonMetadataProvider ipmp;
	
	private PokemonMetadata pmd1 = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
	private PokemonMetadata pmd2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);

	
	@Test
	public void getPokemonMetadataTest() throws PokedexException {
		//pokemon1
		assertEquals(ipmp.getPokemonMetadata(0).getIndex(), pmd1.getIndex());
		assertEquals(ipmp.getPokemonMetadata(0).getName(), pmd1.getName());
		assertEquals(ipmp.getPokemonMetadata(0).getAttack(), pmd1.getAttack());
		assertEquals(ipmp.getPokemonMetadata(0).getDefense(), pmd1.getDefense());
		assertEquals(ipmp.getPokemonMetadata(0).getStamina(), pmd1.getStamina());
		
		//pokemon2
		assertEquals(ipmp.getPokemonMetadata(133).getIndex(), pmd2.getIndex());
		assertEquals(ipmp.getPokemonMetadata(133).getName(), pmd2.getName());
		assertEquals(ipmp.getPokemonMetadata(133).getAttack(), pmd2.getAttack());
		assertEquals(ipmp.getPokemonMetadata(133).getDefense(), pmd2.getDefense());
		assertEquals(ipmp.getPokemonMetadata(133).getStamina(), pmd2.getStamina());
	}

	@Test(expected = PokedexException.class)
	public void execptionIndex() throws PokedexException {
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