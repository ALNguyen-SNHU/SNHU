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
 * Editor: Andrew Liem Nguyen
 * Date: 5/24/2025
 * Time started: 10:43 PM
 *
 * 
 * EDIT: 5/24/2025
 * This class is a simple representation of a player in the gaming room.
 * It contains an identifier and a name, and provides methods to access these attributes.
 * This class is inheriting from the Entity class, which provides a common structure for all entities in the gaming room.
 */
public class Player extends Entity{
	// These 2 attributes are inherited from the Entity class, so they are commented out here.
	// long id;
	//String name;
	
	/*
	 * Constructor with an identifier and name
	 */
	public Player(long id, String name) {
		// this.id = id;
		// this.name = name;
		super(id, name); // Call the constructor of the superclass Entity
	}

	// ID and name are inherited from Entity, so no need to redefine them here.
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

		@Override
    public String toString() {
        // Use the inherited getters instead of direct field access
        // return "Player [id=" + id + ", name=" + name + "]";
        return "Player [id=" + getId() + ", name=" + getName() + "]";
    }
}
