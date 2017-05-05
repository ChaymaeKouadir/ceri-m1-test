package fr.univavignon.pokedex.api;


import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;

public class IPokemonFactoryTest {

	@Mock
	private IPokemonFactory pf;
    private Pokemon p1 ; 


	public void setPokemon(Pokemon pokemon1) {this.p1 = pokemon1;}
	
	@Before
	public void setUp() throws PokedexException{
	
	p1 = new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56);

	MockitoAnnotations.initMocks(this);
    Mockito.when(pf.createPokemon(0, 613, 64, 4000, 4)).thenReturn(p1);
	
	}
	
	@Test
	public void testCreatePokemon() {
        Pokemon tmp = pf.createPokemon(0, 613, 64, 4000, 4);
        assertEquals(tmp.getName(), p1.getName());
        assertEquals(tmp.getAttack(), p1.getAttack());
        assertEquals(tmp.getDefense(), p1.getDefense());
        assertEquals(tmp.getStamina(), p1.getStamina());
        assertEquals(tmp.getCp(), p1.getCp());
        assertEquals(tmp.getHp(), p1.getHp());
        assertEquals(tmp.getDust(), p1.getDust());
        assertEquals(tmp.getIv(), p1.getIv(), 0);
	}
  
}