package fr.univavignon.pokedex.imp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import fr.univavignon.pokedex.api.IPokedex;
import fr.univavignon.pokedex.api.IPokedexFactory;
import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.IPokemonMetadataProvider;
import fr.univavignon.pokedex.api.PokemonTrainer;
import fr.univavignon.pokedex.api.Team;

public class PokemonTrainerFactory {
	
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pxF) {
		ObjectInputStream os = null;

		try {
			
				final FileInputStream file = new FileInputStream(".\\trainers\\"+name+".ser");
				os = new ObjectInputStream(file);
				PokemonTrainer pT = (PokemonTrainer) os.readObject();
				return pT;
				
		} catch (Exception e) {
				
				IPokemonMetadataProvider mP = new PokemonMetadataProvider(); 
				IPokemonFactory pF = new PokemonFactory();
				
				IPokedex pokedex = pxF.createPokedex(mP, pF);
				PokemonTrainer pT = new PokemonTrainer(name, team, pokedex);
				pokedex.setPokemonTrainer(pT);
				return new PokemonTrainer(name, team, pokedex);
			
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
