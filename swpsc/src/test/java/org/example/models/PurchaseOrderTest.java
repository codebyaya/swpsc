package org.example.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderTest {

    @Test
    void testConstructorAndGetters() {
        PurchaseOrder po = new PurchaseOrder("cheese", 5);
        assertEquals("cheese", po.getItem());
        assertEquals(5, po.getQuantity());
        assertTrue(po.toString().contains("cheese"));
    }
}