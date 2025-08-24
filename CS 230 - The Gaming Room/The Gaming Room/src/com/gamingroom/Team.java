package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{

	//LS: created list for the players on the team
	private List<Player> players = new ArrayList<>();

	/**
	 * Constructor with an identifier and name
	 */
	//LS: Utilizing super to use the parent class' constructor
	public Team(long id, String name) {
		super(id, name);
	}

	// LS: removed redundant methods
	// LS: added addPlayer method
	public Player addPlayer(String name) {
		Player player = null;

		// LS: Iterator pattern to check for existing player with same name
		for (Player existingPlayer : players) {
			if (existingPlayer.getName().equalsIgnoreCase(name)) {
				player = existingPlayer;
				break;
			}
		}

		//LS: If not found then create and add the player
		if (player == null) {
			player = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(player);
		}

		return player;
	}
	//LS: swapped to getId and getName
	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}
