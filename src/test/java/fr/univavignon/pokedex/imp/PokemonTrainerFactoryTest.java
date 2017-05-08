package fr.univavignon.pokedex.imp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import fr.univavignon.pokedex.api.*;

public class PokemonTrainerFactoryTest extends IPokemonTrainerFactoryTest {
	
	
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		
		ObjectInputStream os = null;

		try {
			
			final FileInputStream file = new FileInputStream(".\\trainers\\"+name+".ser");
			os = new ObjectInputStream(file);
			
			PokemonTrainer pokemonTrainer = (PokemonTrainer) os.readObject();
			return pokemonTrainer;
			
		} catch (Exception e) {
			
			IPokemonMetadataProvider mp = new PokemonMetadataProvider(); 
			IPokemonFactory pokemonFactory = new PokemonFactory();	
			IPokedex p = pokedexFactory.createPokedex(mp, pokemonFactory);
			return new PokemonTrainer(name, team, p);
			
		} finally {
			try {
				
				if (os != null) {
					os.close();
					
				}
			} catch (final IOException ex) {
				
				ex.printStackTrace();      
				
			}
		}
	}

}
