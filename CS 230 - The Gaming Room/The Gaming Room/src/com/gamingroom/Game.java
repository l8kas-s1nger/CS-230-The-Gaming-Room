package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	//LS: Game now inherits entity
	private List<Team> teams = new ArrayList<>();

	//LS: Utilizing super to use the parent class' constructor
	public Game(long id, String name) {
		super(id, name);
	}

	public Team addTeam(String name) {
		//LS: Local team instance
		Team team = null;

		//LS: Iterator pattern to check for existing team with the same name
		for (Team existingTeam : teams) {
			if (existingTeam.getName().equalsIgnoreCase(name)) {
				team = existingTeam;
				break;
			}
		}

		//LS: If not found then create a new team and add to list
		if (team == null) {
			team = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(team);
		}

		//LS: Return existing or newly created team
		return team;
	}

	//LS: Removed getId and getName as they are redundant
	// and swapped to getName and getId in toString

	@Override
	public String toString() {

		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}

}
