package org.example.models;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> stock = new HashMap<>();

    public void addIngredient(String name, int quantity) {
        stock.put(name, stock.getOrDefault(name, 0) + quantity);
    }

    public void useIngredient(String name, int quantity) {
        stock.put(name, stock.getOrDefault(name, 0) - quantity);
    }

    public int getQuantity(String name) {
        return stock.getOrDefault(name, 0);
    }

    public boolean isLow(String name) {
        return getQuantity(name) < 3;
    }
}