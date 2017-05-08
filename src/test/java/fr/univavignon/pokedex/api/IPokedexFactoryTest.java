package fr.univavignon.pokedex.api;

import org.junit.*;
import org.mockito.*;

import java.util.List;

import static org.junit.Assert.*;

import java.util.ArrayList;



public class IPokedexFactoryTest {
	
	@Mock
    private IPokedex p;
	
	
	@Mock
    private IPokemonFactory pf;
	
	@Mock
    private IPokemonMetadataProvider pmp;

	@Mock
    protected IPokedexFactory pxF;

    @Mock
    private IPokedexFactory ipf;
    
    private Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
	private List<Pokemon> pokemons = new ArrayList<Pokemon>();
 
    
    @Before
	public void setUp() throws PokedexException {
    	MockitoAnnotations.initMocks(this);
    	pokemons.add(pokemon);
		
		Mockito.when(pf.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
		Mockito.when(pxF.createPokedex(pmp,pf)).thenReturn(p);
		Mockito.when(p.size()).thenReturn(0);
		Mockito.when(p.addPokemon(pokemon)).thenReturn(0);
		Mockito.when(p.getPokemon(0)).thenReturn(pokemon);
		Mockito.when(p.getPokemons()).thenReturn(pokemons);
	}
	
    
   @Test 
	public void testCreatePokedex() throws PokedexException{
		IPokedex pokedex = pxF.createPokedex(pmp, pf);
		assertEquals(0, pokedex.size());
		assertEquals(0, pokedex.addPokemon(pokemon));
		assertEquals(pokemon, pokedex.getPokemon(0));
		assertEquals(1, pokedex.getPokemons().size());
		
	} 
}