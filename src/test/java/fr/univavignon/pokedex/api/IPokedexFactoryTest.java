package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import fr.univavignon.pokedex.imp.*;
import org.junit.*;
import org.mockito.*;

import java.util.List;

import java.io.IOException;
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
 
    public IPokedexFactory getProvider() {

        return pxF;
    }

    public IPokemonMetadataProvider getMdp() {
        return pmp;
    }

    public void setMdp(IPokemonMetadataProvider pmp) {
        this.pmp = pmp;
    }

    public IPokemonFactory getPf() {
        return pf;
    }

    public void setPf(IPokemonFactory pf) {
        this.pf = pf;
    }

    public IPokedex getP() {
        return p;
    }

    public void setP(IPokedex p) {
        this.p = p;
    }

    public IPokedexFactory getPxF() {
        return pxF;
    }

    public void setPxF(IPokedexFactory pxF) {
        this.pxF = pxF;
    }
    
    
    @Before
	public void setUp() throws PokedexException {
		pokemons.add(pokemon);
		Mockito.when(pxF.createPokedex(pmp, pf)).thenReturn(p);
		
		Mockito.when(pmp.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"Bulbizarre",126,126,90));
		Mockito.when(pf.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
	
		Mockito.when(p.size()).thenReturn(0);
		Mockito.when(p.addPokemon(pokemon)).thenReturn(0);
		Mockito.when(p.getPokemon(0)).thenReturn(pokemon);
		Mockito.when(p.getPokemons()).thenReturn(pokemons);
	}
	
    
   
   
}