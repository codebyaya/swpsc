package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {


    @Test
    void testAddAndUseIngredient() {
        Inventory inventory = new Inventory();
        inventory.addIngredient("rice", 5);
        inventory.useIngredient("rice", 2);

        assertEquals(3, inventory.getQuantity("rice"));
    }

    @Test
    void testIsLowIngredient() {
        Inventory inventory = new Inventory();
        inventory.addIngredient("tomatoes", 2);

        assertTrue(inventory.isLow("tomatoes"));
        inventory.addIngredient("tomatoes", 2);
        assertFalse(inventory.isLow("tomatoes"));
    }

    @Test
    void testDefaultZero() {
        Inventory inventory = new Inventory();
        assertEquals(0, inventory.getQuantity("unknown"));
    }
}