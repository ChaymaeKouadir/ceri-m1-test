package fr.univavignon.pokedex.imp;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;

public class PokedexFactory implements IPokedexFactory {

	public IPokedex createPokedex(IPokemonMetadataProvider mP, IPokemonFactory pF) {
		return new Pokedex(mP, pF);
	}

}
