package fr.univavignon.pokedex.api;

import java.io.Serializable;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
public class PokemonTrainer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9213027062202254017L;

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
	public PokemonTrainer(String name, Team team,  IPokedex pokedex) {
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

	@Override
	public boolean equals(Object t){
		if(!(t instanceof PokemonTrainer))return false;
		if((this.getTeam() != ((PokemonTrainer) t).getTeam()))return false;
		return this.name.equals(((PokemonTrainer) t).getName());
		
	}
}
