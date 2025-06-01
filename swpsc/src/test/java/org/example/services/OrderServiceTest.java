package org.example.services;

import org.example.models.Customer;
import org.example.models.Order;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Test
    void testCreateValidOrder() {
        Customer customer = new Customer("Ali", "none");
        List<String> ingredients = List.of("rice", "chicken");
        Order order = OrderService.createOrder(customer, ingredients);

        assertTrue(order.isValid());
        assertEquals(1, customer.getOrderHistory().size());
    }

    @Test
    void testCreateInvalidOrder() {
        Customer customer = new Customer("Sara", "vegan");
        List<String> ingredients = List.of("cheese", "milk");
        Order order = OrderService.createOrder(customer, ingredients);

        assertFalse(order.isValid());
        assertEquals(1, customer.getOrderHistory().size());
    }
}