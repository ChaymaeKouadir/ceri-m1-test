package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.util.Comparator;

import org.junit.*;
import org.mockito.Mockito.*;
import org.mockito.*;
import java.io.IOException;



public class IPokedexFactoryTest {
	
	@Mock
    private IPokedex p;
	
	
	@Mock
    private IPokemonFactory pf;
	
	@Mock
    private IPokemonMetadataProvider mdp;

	@Mock
    private IPokedexFactory pxF;

    @Mock
    private IPokedexFactory ipf;

    
    public IPokedexFactory getProvider() {

        return pxF;
    }

    public IPokemonMetadataProvider getMdp() {
        return mdp;
    }

    public void setMdp(IPokemonMetadataProvider mdp) {
        this.mdp = mdp;
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
    public void setUp() throws PokedexException, IOException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(pxF.createPokedex(mdp, pf)).thenReturn(p);
    }
    
    @Test
    public void createPokedexTest() throws IOException {
        assertNotNull(getProvider().createPokedex(mdp, pf));
    }

   
}