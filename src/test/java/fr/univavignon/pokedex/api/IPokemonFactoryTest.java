package fr.univavignon.pokedex.api;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;


public class IPokemonFactoryTest {

	@Mock
	protected IPokemonFactory pF;

	public Pokemon p1 ; 


	public void setPokemon(Pokemon pokemon1) {this.p1 = pokemon1;}

	@Before
	public void setUp() throws PokedexException{
		MockitoAnnotations.initMocks(this);
		p1 = new Pokemon(0,"Bulbassaur",126,126,90,613,64,4000,4,0);
		Mockito.when(pF.createPokemon(0, 613, 64, 4000, 4)).thenReturn(p1);
		Mockito.when(pF.createPokemon(-1, 613, 64, 4000, 4)).thenReturn(null);
	}

	@Test
	public void testCreatePokemon() {
		Pokemon tmp = pF.createPokemon(0, 613, 64, 4000, 4);
		assertEquals(tmp.getIndex(), p1.getIndex());
		assertEquals(tmp.getName(), p1.getName());
		assertEquals(tmp.getAttack(), p1.getAttack());
		assertEquals(tmp.getDefense(), p1.getDefense());
		assertEquals(tmp.getStamina(), p1.getStamina());
		assertEquals(tmp.getCp(), p1.getCp());
		assertEquals(tmp.getHp(), p1.getHp());
		assertEquals(tmp.getDust(), p1.getDust());
		assertEquals(tmp.getIv(), p1.getIv(), 0);
	}
	
	@Test
	public void testErreur() throws Exception{
		assertNull(pF.createPokemon(-1, 613, 64, 4000, 4));
	}

}