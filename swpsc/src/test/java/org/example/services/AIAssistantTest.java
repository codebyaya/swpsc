package org.example.services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AIAssistantTest {

    @Test
    void testVeganRecipePasta() {
        String result = AIAssistant.recommendRecipe("vegan", List.of("pasta", "basil", "tomatoes"), 25);
        assertTrue(result.toLowerCase().contains("pasta"));
    }

    @Test
    void testVeganRecipeSoup() {
        String result = AIAssistant.recommendRecipe("vegan", List.of("mushroom", "onion"), 15);
        assertTrue(result.toLowerCase().contains("soup"));
    }

    @Test
    void testVeganNoMatch() {
        String result = AIAssistant.recommendRecipe("vegan", List.of("banana"), 5);
        assertTrue(result.toLowerCase().contains("no suitable"));
    }

    @Test
    void testVegetarianPizza() {
        String result = AIAssistant.recommendRecipe("vegetarian", List.of("cheese", "tomatoes", "bread"), 20);
        assertTrue(result.toLowerCase().contains("pizza"));
    }

    @Test
    void testVegetarianOmelet() {
        String result = AIAssistant.recommendRecipe("vegetarian", List.of("eggs", "spinach"), 10);
        assertTrue(result.toLowerCase().contains("omelet"));
    }

    @Test
    void testVegetarianNoMatch() {
        String result = AIAssistant.recommendRecipe("vegetarian", List.of("water"), 5);
        assertTrue(result.toLowerCase().contains("no suitable"));
    }

    @Test
    void testKetoRecipeMeat() {
        String result = AIAssistant.recommendRecipe("keto", List.of("meat", "cheese", "butter"), 30);
        assertTrue(result.toLowerCase().contains("meat"));
    }

    @Test
    void testKetoRecipeAvocado() {
        String result = AIAssistant.recommendRecipe("keto", List.of("eggs", "avocado"), 12);
        assertTrue(result.toLowerCase().contains("avocado"));
    }

    @Test
    void testKetoNoMatch() {
        String result = AIAssistant.recommendRecipe("keto", List.of("lettuce"), 5);
        assertTrue(result.toLowerCase().contains("no suitable"));
    }

    @Test
    void testNoneRiceChicken() {
        String result = AIAssistant.recommendRecipe("none", List.of("rice", "chicken", "carrot"), 35);
        assertTrue(result.toLowerCase().contains("rice"));
    }

    @Test
    void testNoneEggToast() {
        String result = AIAssistant.recommendRecipe("none", List.of("eggs", "cheese", "bread"), 12);
        assertTrue(result.toLowerCase().contains("toast"));
    }

    @Test
    void testNoneQuickSuggestion() {
        String result = AIAssistant.recommendRecipe("none", List.of("lettuce"), 5);
        assertTrue(result.toLowerCase().contains("salad") || result.toLowerCase().contains("sandwich"));
    }

    @Test
    void testUnknownDiet() {
        String result = AIAssistant.recommendRecipe("unknown", List.of("rice"), 20);
        assertTrue(result.toLowerCase().contains("unable to suggest"));
    }
}