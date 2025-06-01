package org.example.services;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class NotificationServiceTest {

    @Test
    void testNotifyUser() {
        // Capture console output
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(output));

        // Call the method
        NotificationService.notifyUser("Low stock!");

        // Restore original output
        System.setOut(original);

        // Assert output contains expected message
        assertTrue(output.toString().contains("[Notification] Low stock!"));
    }
}