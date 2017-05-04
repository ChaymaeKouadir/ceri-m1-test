package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import java.util.*;

public class IPokedexTest {

    @Mock
    private IPokedex p;

    private int nb = 0;
    private List<Pokemon> list_pokemons = new ArrayList<Pokemon>(151);

    private Pokemon p1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);
    private Pokemon p2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
	

	@Test
	public void addPokemonTest() {
        assertEquals(p.addPokemon(p1), 0);
        assertEquals(p.addPokemon(p2), 1);
	}
	
	@Test
	public void getPokemonTest() throws PokedexException {
        assertEquals(p.getPokemon(0), p1);
        assertEquals(p.getPokemon(1), p2);
	}
	
	@Test
	public void getPokemonsTest(){
        List<Pokemon> l = p.getPokemons();
        assertEquals(l, list_pokemons);
	}
	
    @Test
    public void sizeTest() {
        assertEquals(p.size(), 2);
    }


    @Before
    public void setUp() throws PokedexException {
    	
        MockitoAnnotations.initMocks(this);
         Mockito.when(p.addPokemon(p1)).thenReturn(nb);
        list_pokemons.add(p1);
        nb++;
        
        Mockito.when(p.addPokemon(p2)).thenReturn(nb);
        list_pokemons.add(p2);
        nb++;
        
        Mockito.when(p.size()).thenReturn(nb);
        Mockito.when(p.getPokemon(0)).thenReturn(p1);
        Mockito.when(p.getPokemon(1)).thenReturn(p2);
        Mockito.when(p.getPokemons()).thenReturn(list_pokemons);
    }
}