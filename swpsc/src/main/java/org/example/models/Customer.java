package org.example.models;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String dietaryPreference;
    private List<Order> orderHistory = new ArrayList<>();

    public Customer(String name, String dietaryPreference) {
        this.name = name;
        this.dietaryPreference = dietaryPreference;
    }

    public String getName() {
        return name;
    }

    public String getDietaryPreference() {
        return dietaryPreference;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
}