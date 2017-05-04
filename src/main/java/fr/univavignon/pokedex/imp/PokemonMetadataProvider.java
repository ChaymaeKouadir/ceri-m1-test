package fr.univavignon.pokedex.imp;

import java.io.Serializable;
import org.apache.http.client.fluent.Request;
import org.json.*;
import fr.univavignon.pokedex.api.*;

public class PokemonMetadataProvider implements IPokemonMetadataProvider, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		if((index < 0) || (index > 150))
			throw new PokedexException("Index should be between 0 and 150 !");
		try {
			String pokInfos = Request.Get("https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json").execute().returnContent().asString();
			JSONArray pokemons = new JSONArray(pokInfos);	
			JSONObject pObject = pokemons.getJSONObject(index);
			PokemonMetadata pmd = getPokemonMetadataFromJSONObject(pObject);
			return pmd;
			
		} catch (Exception e) {
			throw new PokedexException("Exception raised");
		}
	}

	
	public PokemonMetadata getPokemonMetadataFromJSONObject(JSONObject data) throws JSONException{
		
		PokemonMetadata pmd;
		pmd = new PokemonMetadata(	
				data.getInt("PkMn")-1,
				data.getString("Identifier"), 
				data.getInt("BaseAttack"), 
				data.getInt("BaseDefense"), 
				data.getInt("BaseStamina"));
		return pmd;
		
	}
	
}
