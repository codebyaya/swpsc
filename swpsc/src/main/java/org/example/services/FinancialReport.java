package org.example.services;

public class FinancialReport {
    private static double total = 0;
    private static int orders = 0;

    public static void record(double amount) {
        total += amount;
        orders++;
    }

    public static void printReport() {
        System.out.println("Financial Report:");
        System.out.println("Total Orders: " + orders);
        System.out.println("Total Revenue: $" + total);
    }
}