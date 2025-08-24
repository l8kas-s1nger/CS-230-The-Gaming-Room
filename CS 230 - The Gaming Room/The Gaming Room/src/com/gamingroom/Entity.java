package com.gamingroom;

// LS: Added/set up Entity class so that it is in line with UML diagram/directions
public class Entity {
    long id;
    String name;

    // exists because of UML diagram
    public Entity() {
    }

    //LS: Constructor for id and name
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    //LS: created getter for Id which is used in the inherited classes
    public long getId() {
        return id;
    }

    //LS: created getter for name which is used in the inherited classes
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + "]";
    }
}
