package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;

	//LS: Private static instance for singleton pattern
	// Modified variable name (in all usages) from instance to service to be in line with UML
	//Using LS to signify my comments as otherwise it might be confusing between the existing comments and mine
	private static GameService service;

	// LS: Singleton Pattern:
	// Makes sure that only one instance of GameService exists in memory at any time.
	// This central instance allows coordinated management of all game data,
	// avoiding duplicate or conflicting game service logic.

	//LS: Constructor for GameService
	private GameService() {
	}
	// LS: Singleton Pattern:
	// getInst() checks if an instance exists and creates one if not already existing.
	// Essentially, validates that only a single shared GameService object is used throughout the application

	public static GameService getInstance() {
		if (service == null) {
				service = new GameService();
			}
		return service;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// LS: Iterator Pattern below:
		// Uses a for loop to loop through all games to see if there is an
		// existing game so as to avoid duplicates with the same name or ID (in the case below)
		// this results in a check for all existing games
		for (Game existingGame : games) {
			if (existingGame.getName().equalsIgnoreCase(name)) {
				game = existingGame;
				break;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// LS: Iterator Pattern below:
		// Loops through all games to see if there is an existing game
		// with the same id (virtually same as above iterator with id instead)
		for (Game existingGame : games) {
			if (existingGame.getId() == id) {
				game = existingGame;
				break;
			}
		}
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// LS: Iterator Pattern below:
		// Uses a for loop to loop through all games to see if there is an
		// existing game so as to avoid duplicates with the same name
		// this results in a check for all existing games
		for (Game existingGame : games) {
			if (existingGame.getName().equalsIgnoreCase(name)) {
				game = existingGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	// LS: added both getNextTeamId and getNextPlayerId methods
	public long getNextTeamId() {
		return nextTeamId++;
	}

	public long getNextPlayerId() {
		return nextPlayerId++;
	}
}
