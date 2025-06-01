package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testConstructorAndGetters() {
        Task task = new Task("Prepare meal", "Chef-1");
        assertEquals("Prepare meal", task.getDescription());
        assertEquals("Chef-1", task.getAssignedTo());
    }

    @Test
    void testToStringFormat() {
        Task task = new Task("Cook pasta", "Chef-2");
        String result = task.toString();
        assertTrue(result.contains("Cook pasta"));
        assertTrue(result.contains("Chef-2"));
    }
}