package org.example.models;

public class Invoice {
    private double total;
    private String customerName;

    public Invoice(String customerName, double total) {
        this.customerName = customerName;
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public String getCustomerName() {
        return customerName;
    }
}