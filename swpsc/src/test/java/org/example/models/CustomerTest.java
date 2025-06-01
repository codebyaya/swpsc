package org.example.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void testAddOrderAndGetHistory() {
        Customer customer = new Customer("Lina", "vegan");
        Order order = new Order(List.of("pasta", "tomatoes"), true);

        customer.addOrder(order);

        assertEquals(1, customer.getOrderHistory().size());
        assertEquals(order, customer.getOrderHistory().get(0));
    }

    @Test
    void testGetNameAndDiet() {
        Customer c = new Customer("Zaid", "keto");

        assertEquals("Zaid", c.getName());
        assertEquals("keto", c.getDietaryPreference());
    }
}
