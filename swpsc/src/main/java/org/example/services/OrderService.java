package org.example.services;
import org.example.models.*;
import org.example.utils.IngredientValidator;
import java.util.List;

public class OrderService {
    public static Order createOrder(Customer customer, List<String> ingredients) {
        boolean valid = IngredientValidator.validate(ingredients, customer.getDietaryPreference());
        Order order = new Order(ingredients, valid);
        customer.addOrder(order);

        if (valid) {
            Invoice invoice = new Invoice(customer.getName(), 10.0 + ingredients.size() * 2.0);
            System.out.println("Invoice:");
            System.out.println("Customer: " + invoice.getCustomerName());
            System.out.println("Total Amount: $" + invoice.getTotal());
            FinancialReport.record(invoice.getTotal());
        }

        return order;
    }
}