package org.example.utils;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IngredientValidatorTest {

    @Test
    void testValidateVeganSuccess() {
        List<String> ingredients = List.of("pasta", "tomatoes");
        assertTrue(IngredientValidator.validate(ingredients, "vegan"));
    }

    @Test
    void testValidateVeganFail() {
        List<String> ingredients = List.of("meat", "basil");
        assertFalse(IngredientValidator.validate(ingredients, "vegan"));
    }

    @Test
    void testSuggestSubstitutions() {
        List<String> ingredients = List.of("meat", "cheese");
        Map<String, String> suggestions = IngredientValidator.suggestSubstitutions(ingredients, "vegan");

        assertEquals("mushroom", suggestions.get("meat"));
        assertEquals("tofu", suggestions.get("cheese"));
    }
}