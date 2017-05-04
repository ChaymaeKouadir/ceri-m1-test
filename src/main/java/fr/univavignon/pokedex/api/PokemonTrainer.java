package fr.univavignon.pokedex.api;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
public class PokemonTrainer {

	/** Trainer name. **/
	private final String name;

	/** Trainer team. **/
	private final Team team;
	
	/** Trainer pokedex. **/
	private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 * 
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}
	
	/** Name getter. **/
	public String getName() {
		return name;
	}

	/** Team getter. **/
	public Team getTeam() {
		return team;
	}
	
	/** Pokedex getter. **/
	public IPokedex getPokedex() {
		return pokedex;
	}
	
	public void saveAsFile(){
			ObjectOutputStream oS = null;
			
			try {
					final FileOutputStream file = new FileOutputStream(".\\trainers\\"+name+".ser");
					oS = new ObjectOutputStream(file);
					oS.writeObject(this);
					oS.flush();
					
			} catch (Exception e) {
				
					e.printStackTrace();  
			} finally {
				
					try {
						if (oS != null) {
							oS.flush();
							oS.close();
					}
				} catch (final IOException ex) {
						ex.printStackTrace();	
				}
			}
	}
	
}
