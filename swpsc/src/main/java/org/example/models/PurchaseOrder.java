package org.example.models;

public class PurchaseOrder {
    private String item;
    private int quantity;

    public PurchaseOrder(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "[PurchaseOrder] " + item + " × " + quantity;
    }
}