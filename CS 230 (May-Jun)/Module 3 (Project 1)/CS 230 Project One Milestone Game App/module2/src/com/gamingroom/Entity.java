/*
 * Entity.java
 * This file is part of the Gaming Room project.
 * This class serves as a base class for Game, Players, and Teams. All three will inherit from this class.
 * It provides a common structure and functionality that can be extended by the subclasses.
 * Name: Andrew Liem Nguyen
 * Date: 5/24/2025
 * Time started: 10:13 PM
 */

package com.gamingroom;
public class Entity {
    // UML states there are 2 attributes: id: long, name: String
    private long id;
    private String name;

    // UML states there are 2 constructors: one with no parameters and one with id and name parameters
    public Entity() {
        this.id = 0;
        this.name = "";
    }
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }
    // UML states there are 3 more methods: getId(), getName(), and toString()
    // Getter for the id of the entity
    public long getId() {
        return id;
    }

    // Getter for the name of entity
    public String getName() {
        return name;
    }
    
    // Override the toString() method to provide a string representation of the Entity
    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}