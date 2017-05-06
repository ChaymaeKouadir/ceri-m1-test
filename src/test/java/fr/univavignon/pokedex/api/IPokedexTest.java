package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import java.util.*;

public class IPokedexTest{

    @Mock
	protected IPokedex p;
    

    private List<Pokemon> list_pokemons = new ArrayList<Pokemon>(151);

	private PokemonMetadata p1mD = new PokemonMetadata(0,"Bulbasaur",126,126,90);
    protected Pokemon p1 = new Pokemon(0,"Bulbasaur",126,126,90,613,64,4000,4,56);
    protected Pokemon p2 = new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100);
	
    @Before
    public void setUp() throws PokedexException {
    	MockitoAnnotations.initMocks(this);
    	list_pokemons.add(p1);
		Mockito.when(p.size()).thenReturn(0);
		Mockito.when(p.addPokemon(p2)).thenReturn(1);
		Mockito.when(p.getPokemon(0)).thenReturn(p1);
		Mockito.when(p.getPokemons()).thenReturn(list_pokemons);
		Mockito.when(p.getPokemon(-1)).thenThrow(new PokedexException("Error"));
		
		List<Pokemon> pnames = new ArrayList<Pokemon>();
		pnames.add(p2);
		pnames.add(p1);
		List<Pokemon> pIps = new ArrayList<Pokemon>();
		pIps.add(p1);
		pIps.add(p2);
		List<Pokemon> pindex = new ArrayList<Pokemon>();
		pindex.add(p1);
		pindex.add(p2);
		Mockito.when(p.getPokemons(PokemonComparators.NAME)).thenReturn(pnames);
		Mockito.when(p.getPokemons(PokemonComparators.CP)).thenReturn(pIps);
		Mockito.when(p.getPokemons(PokemonComparators.INDEX)).thenReturn(pindex);
		
		Mockito.when(p.getPokemonMetadata(0)).thenReturn(p1mD);
		Mockito.when(p.createPokemon(0, 613, 64, 4000, 4)).thenReturn(p1);
    }

    @Test
    (expected=PokedexException.class)
	public void execptionIndex() throws PokedexException{
	p.getPokemon(-1);
	}
	
	@Test 
	public void testPx() throws PokedexException{
		
	assertEquals(0, p.size());
	assertEquals(0, p.addPokemon(p1));
	assertEquals(p1, p.getPokemon(0));
	assertEquals(1, p.getPokemons().size());
	}
	
	@Test 
	public void testCPComparatorPokedex() {
		
	assertEquals(0, p.size());
	assertEquals(0, p.addPokemon(p1));
	assertEquals(1, p.addPokemon(p2));
	
	List<Pokemon> pokemonsSortedByCP = p.getPokemons(PokemonComparators.CP);
	assertEquals(0, pokemonsSortedByCP.get(0).getIndex());
	assertEquals(133, pokemonsSortedByCP.get(1).getIndex());
		
	}
	
	@Test 
	public void testIndexCmpPx() {
		
	assertEquals(0, p.size());
	assertEquals(0, p.addPokemon(p1));
	assertEquals(1, p.addPokemon(p2));
	
	List<Pokemon> pokemonsSortedByIndex = p.getPokemons(PokemonComparators.INDEX);
	assertEquals(0, pokemonsSortedByIndex.get(0).getIndex());
	assertEquals(133, pokemonsSortedByIndex.get(1).getIndex());
		
	}
	
	@Test 
	public void getPmdaWithPx() throws PokedexException {
		
	PokemonMetadata pmdC = p.getPokemonMetadata(0);
	assertEquals(p1mD.getAttack(), pmdC.getAttack());
	assertEquals(p1mD.getDefense(), pmdC.getDefense());
	assertEquals(p1mD.getIndex(), pmdC.getIndex());
	assertEquals(p1mD.getName(), pmdC.getName());
		
	}
	
	@Test 
	public void testCreatePx() {
		
	Pokemon pokemon = p.createPokemon(0, 613, 64, 4000, 4);
	assertEquals(p1.getAttack(), pokemon.getAttack());
	assertEquals(p1.getDefense(), pokemon.getDefense());
	assertEquals(p1.getIndex(), pokemon.getIndex());
	assertEquals(p1.getName(), pokemon.getName());
	assertEquals(p1.getCandy(), pokemon.getCandy());
	assertEquals(p1.getCp(), pokemon.getCp());
	assertEquals(p1.getName(), pokemon.getName());
		
		
	}
}