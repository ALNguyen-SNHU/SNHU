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
public class Game extends Entity{
	// long id;		// Inherited from Entity class
	// String name;	// Inherited from Entity class
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	// A game consists of a List<> of teams as defined in the UML diagram (-teams: List<Team>)
	private List<Team> teams = new ArrayList<>();
	
	// private Game() {
	// }

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		// this();			// All three lines below are inherited from Entity class
		// this.id = id;
		// this.name = name;
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

	// Adds a team to the game
	public Team addTeam(String name) {
		// For each team in the game...
        for (Team team : teams) {
			// If the team's name matches the given name...
            if (team.getName().equalsIgnoreCase(name)) {
                // Return null to indicate that the team already exists
				return null; // Name already exists
            }
        }
        // The same logic that was used to add a player to a team is currently being used here.
		Team team = new Team(teams.size() + 1, name); // may want to use a better id system
        teams.add(team);
        return team;
    }

    @Override
    public String toString() {
        // return "Game [id=" + id + ", name=" + name + "]";
        return "Game [id=" + getId() + ", name=" + getName() + ", teams=" + teams.size() + "]";
    }
}
