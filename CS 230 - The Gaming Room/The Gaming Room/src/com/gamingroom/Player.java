package com.gamingroom;

/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Player extends Entity{
	//LS: Refactored player to extend Entity

	//LS: Utilizing super to use the parent class' constructor
	public Player(long id, String name) {
		super(id, name);
	}

	// swapped id and name to getId() and getName()
	@Override
	public String toString() {
		return "Player [id=" + getId() + ", name=" + getName() + "]";
	}
}
