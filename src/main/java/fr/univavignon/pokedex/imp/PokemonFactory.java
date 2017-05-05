package fr.univavignon.pokedex.imp;

import java.io.Serializable;

import fr.univavignon.pokedex.api.*;

public class PokemonFactory implements IPokemonFactory, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7493080326984188907L;
	int nb=0;
	
	public double calculating(String name, int cp, int dust){
		
		return nb;
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		
		PokemonMetadataProvider pmp = new PokemonMetadataProvider();
		PokemonMetadata pmd;
		
		try {
			pmd = pmp.getPokemonMetadata(index);
		} catch (PokedexException e) {
			return null;
		}
		
		String name = pmd.getName();
		int attack = pmd.getAttack();
		int defense = pmd.getDefense();
		int stamina = pmd.getStamina();
		double iv = calculating(name, cp, dust);
		Pokemon pok = new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
		return pok;
	}
}
