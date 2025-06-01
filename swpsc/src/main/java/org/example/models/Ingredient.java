package org.example.models;

public class Ingredient {
    private String name;
    private boolean available;

    public Ingredient(String name, boolean available) {
        this.name = name;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return available;
    }
}
