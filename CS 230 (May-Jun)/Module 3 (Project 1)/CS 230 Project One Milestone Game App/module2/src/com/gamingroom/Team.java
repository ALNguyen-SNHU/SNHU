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
 * Editor: Andrew Liem Nguyen
 * Date: 5/24/2025
 * Time started: 12:10 AM
 *
 */

 // Inherit from Entity class
public class Team extends Entity{
	// long id;
	// String name;
	// A Team consists of a List<> of players as defined in the UML diagram (-players: List<Player>)
	private List<Player> players = new ArrayList<>();

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		// this.id = id;		// Inherited from Entity class
		// this.name = name;	// Inherited from Entity class
		super(id, name); // Call the constructor of the superclass Entity
	}

	// /**
	//  * @return the id
	//  */
	// public long getId() {
	// 	return id;
	// }

	// /**
	//  * @return the name
	//  */
	// public String getName() {
	// 	return name;
	// }

	// Adds a player to the team
	public Player addPlayer(String name) {
		// For each player in the team...
        for (Player player : players) {
			// If the player's name matches the given name...
            if (player.getName().equalsIgnoreCase(name)) {
				// Return null to indicate that the player already exists
                return null; // Name already exists
            }
        }
		// If the name is unique, create a new player ID by using the current size of the players list
		// and incrementing it by 1 (this is a simple way to generate unique IDs)
        Player player = new Player(players.size() + 1, name); // You may want to use a better id system
        // Add the new player to the players list
		players.add(player);
        return player;
    }

	// @Override
	// public String toString() {
	// 	return "Team [id=" + id + ", name=" + name + "]";
	
	@Override
    public String toString() {
        // return "Team [id=" + id + ", name=" + name + "]";
        return "Team [id=" + getId() + ", name=" + getName() + ", players=" + players.size() + "]";
	}
}
