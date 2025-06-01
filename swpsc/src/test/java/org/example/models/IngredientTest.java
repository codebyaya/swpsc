package org.example.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    @Test
    void testConstructorAndGetters() {
        Ingredient ing = new Ingredient("tomato", true);
        assertEquals("tomato", ing.getName());
        assertTrue(ing.isAvailable());
    }
}