package com.library.model;

/**
 * Abstract base class representing a generic person in the library system.
 * Demonstrates ABSTRACTION (cannot be instantiated directly) and
 * ENCAPSULATION (private fields with controlled access via getters).
 */
public abstract class Person {

    private final String id;
    private String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Every subclass must define its own role description.
     * Forces POLYMORPHIC behaviour when called on a Person reference.
     */
    public abstract String getRole();

    @Override
    public String toString() {
        return getRole() + " [id=" + id + ", name=" + name + "]";
    }
}
