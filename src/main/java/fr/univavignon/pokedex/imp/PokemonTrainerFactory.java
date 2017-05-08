package fr.univavignon.pokedex.imp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import fr.univavignon.pokedex.api.*;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		ObjectInputStream os = null;

		try {
			
				final FileInputStream file = new FileInputStream(".\\trainers\\"+name+".ser");
				os = new ObjectInputStream(file);
				PokemonTrainer pT = (PokemonTrainer) os.readObject();
				return pT;
			
		} catch (Exception e) {
			
				IPokemonMetadataProvider mp = new PokemonMetadataProvider(); 
				IPokemonFactory pf = new PokemonFactory();
				
				IPokedex pokedex = pokedexFactory.createPokedex(mp, pf);
				PokemonTrainer pT = new PokemonTrainer(name, team, pokedex);
				pokedex.setPokemonTrainer(pT);
				return new PokemonTrainer(name, team, pokedex);
			
		} finally {
				try {
					if (os != null) {
						os.close();
					}
				} catch (final IOException e) {
					e.printStackTrace();        
			}
		}
	}
}