package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 * Edited by: Andrew L. Nguyen
 * Date: 05/15/2025
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
	// Added for player and team IDs
	// Holds the next player and team identifiers
	// These are used to ensure that each player and team has a unique ID.
	// This is important for tracking players and teams in the game.
	private static long nextPlayerId = 1; // Added for player IDs
    private static long nextTeamId = 1;   // Added for team IDs

	// FIXME: Add missing pieces to turn this class a singleton 
	// Missing components: private static instance variable, private constructor, public static accessor method
	/*
	 * Explanation: Singleton ensures that only one instance of the class exists. We don't want separate lists of games.
	 * Analogy: Steam or Epic Games Launcher - you don't want multiple instances of the same game running.
	 * Averted: GameService gs1 = new GameService(); GameService gs2 = new GameService();
	 */
	private static GameService instance;

	private GameService() {
		games = new ArrayList<>();
		nextGameId = 1;
		// Add player ID an team ID initializations
		nextPlayerId = 1; // Initialize player ID
		nextTeamId = 1;   // Initialize team ID
	}

	public static GameService getInstance() {
		if (instance == null) {
			instance = new GameService();
		}
		return instance;
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

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance

		/*
		 * Explanation: Prevent duplicate games with the same name.
		 * Analogy: 2 instances of a game you bought once. You don't want to buy the same game twice.
		 */
		// iterate through the list of games. Check for games with matching names.
		for (Game g : games) {
			if (g.getName().equalsIgnoreCase(name)) {
				game = g;
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

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable

		/*
		 * Explanation: Games have IDs. We need to be able to find them by ID. Right now, they are null.
		 * Each ID should be unique.
		 */

		// iterate through the list of games. Check for games with matching names.
		for (Game g : games) {
			if (g.getId() == id) {
				game = g;
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

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable

		for (Game g : games) {
			if (g.getName().equalsIgnoreCase(name)) {
				game = g;
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
    
	/**
     * Returns the next unique player ID and increments the counter.
     * @return next player ID
     */
    public long getNextPlayerId() {
        return nextPlayerId++;
    }

    /**
     * Returns the next unique team ID and increments the counter.
     * @return next team ID
     */
    public long getNextTeamId() {
        return nextTeamId++;
    }
}

// As of current, there are no fall backs for each function.
// If a game is not found, it will return null.
// No exceptions are thrown. No errors are thrown.
// This isn't in the instructions, but it is a good idea to add this.