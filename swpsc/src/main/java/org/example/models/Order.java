package org.example.models;
import java.util.List;

public class Order {
    private List<String> ingredients;
    private boolean valid;

    public Order(List<String> ingredients, boolean valid) {
        this.ingredients = ingredients;
        this.valid = valid;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public boolean isValid() {
        return valid;
    }
}