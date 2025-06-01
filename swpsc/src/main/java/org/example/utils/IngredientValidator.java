package org.example.utils;
import java.util.*;

public class IngredientValidator {
    private static final Map<String, List<String>> restricted = Map.of(
            "vegan", List.of("meat", "cheese", "milk", "eggs")
    );

    private static final Map<String, String> substitutions = Map.of(
            "cheese", "tofu",
            "meat", "mushroom",
            "milk", "almond milk",
            "eggs", "chia seeds"
    );

    public static boolean validate(List<String> ingredients, String diet) {
        List<String> restrictedItems = restricted.getOrDefault(diet.toLowerCase(), List.of());
        for (String item : ingredients) {
            if (restrictedItems.contains(item.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public static Map<String, String> suggestSubstitutions(List<String> ingredients, String diet) {
        Map<String, String> suggested = new HashMap<>();
        List<String> restrictedItems = restricted.getOrDefault(diet.toLowerCase(), List.of());
        for (String item : ingredients) {
            if (restrictedItems.contains(item.toLowerCase()) && substitutions.containsKey(item.toLowerCase())) {
                suggested.put(item, substitutions.get(item.toLowerCase()));
            }
        }
        return suggested;
    }
}