package org.example.services;

import java.util.List;

public class AIAssistant {


    public static String recommendRecipe(String diet, List<String> availableIngredients, int timeAvailable) {
        if (diet.equalsIgnoreCase("vegan")) {
            if (has(availableIngredients, "pasta", "tomatoes", "basil") && timeAvailable >= 20) {
                return " Suggested Recipe: Pasta with tomato and basil sauce (20 minutes)";
            } else if (has(availableIngredients, "mushroom", "onion") && timeAvailable >= 15) {
                return " Suggested Recipe: Vegan mushroom and onion soup (15 minutes)";
            } else if (has(availableIngredients, "cucumber", "tomatoes", "lettuce") && timeAvailable >= 10) {
                return " Suggested Recipe: Fresh vegetable salad (10 minutes)";
            } else {
                return " No suitable vegan recipe found based on available ingredients and time.";
            }
        }

        if (diet.equalsIgnoreCase("vegetarian")) {
            if (has(availableIngredients, "cheese", "tomatoes", "bread") && timeAvailable >= 15) {
                return " Suggested Recipe: Cheese and tomato bread pizza (15 minutes)";
            } else if (has(availableIngredients, "eggs", "spinach") && timeAvailable >= 10) {
                return "Suggested Recipe: Spinach omelet (10 minutes)";
            } else {
                return "No suitable vegetarian recipe found.";
            }
        }

        if (diet.equalsIgnoreCase("keto")) {
            if (has(availableIngredients, "meat", "cheese", "butter") && timeAvailable >= 25) {
                return " Suggested Recipe: Grilled meat with cheese and butter (25 minutes)";
            } else if (has(availableIngredients, "eggs", "avocado") && timeAvailable >= 10) {
                return " Suggested Recipe: Eggs with avocado (10 minutes)";
            } else {
                return " No suitable keto recipe found.";
            }
        }

        if (diet.equalsIgnoreCase("none")) {
            if (has(availableIngredients, "rice", "chicken", "carrot") && timeAvailable >= 30) {
                return " Suggested Recipe: Rice with chicken and vegetables (30 minutes)";
            } else if (has(availableIngredients, "eggs", "cheese", "bread") && timeAvailable >= 10) {
                return " Suggested Recipe: Toast with eggs and cheese (10 minutes)";
            } else {
                return " Quick suggestion: Salad or sandwich based on available ingredients.";
            }
        }

        return " Unable to suggest a recipe based on the provided input.";
    }

    // Helper method to check if all required ingredients are available
    private static boolean has(List<String> ingredients, String... required) {
        for (String r : required) {
            if (!ingredients.contains(r)) return false;
        }
        return true;
    }
}