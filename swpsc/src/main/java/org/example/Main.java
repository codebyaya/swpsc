package org.example;

import org.example.models.*;
import org.example.services.*;
import org.example.utils.*;

import java.util.*;

public class Main {
    private static final List<Customer> customers = new ArrayList<>();
    private static final Inventory inventory = new Inventory();
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Task> tasks = new ArrayList<>();
    private static final List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public static void main(String[] args) {
        seedInventory(); // Initial stock

        while (true) {
            System.out.println("\n=== Special Cook System ===");
            System.out.println("1. Create new customer");
            System.out.println("2. View customers");
            System.out.println("3. Place an order");
            System.out.println("4. View order history");
            System.out.println("5. AI recipe recommendation");
            System.out.println("6. View inventory alerts");
            System.out.println("7. View tasks");
            System.out.println("8. View financial report");
            System.out.println("0. Exit");

            String choice = readNumberOption("Choose: ");

            switch (choice) {
                case "1" -> createCustomer();
                case "2" -> listCustomers();
                case "3" -> makeOrder();
                case "4" -> viewOrders();
                case "5" -> aiRecommendation();
                case "6" -> checkInventory();
                case "7" -> showTasks();
                case "8" -> FinancialReport.printReport();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    // Helper method to read numeric input with validation
    private static String readNumberOption(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.matches("\\d+")) return input;
            System.out.println("Please enter a valid number.");
        }
    }

    // Add initial stock
    private static void seedInventory() {
        inventory.addIngredient("pasta", 10);
        inventory.addIngredient("tomatoes", 5);
        inventory.addIngredient("basil", 4);
        inventory.addIngredient("cheese", 1);
        inventory.addIngredient("meat", 1);
    }

    // Create a new customer with dietary preference
    private static void createCustomer() {
        String name;
        while (true) {
            System.out.print("Enter customer name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty.");
            } else if (name.matches(".*\\d.*")) {
                System.out.println("Name cannot contain numbers.");
            } else break;
        }

        List<String> diets = List.of("vegan", "vegetarian", "keto", "none");

        String pref = "";
        while (true) {
            System.out.println("Choose dietary preference:");
            for (int i = 0; i < diets.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, diets.get(i));
            }
            System.out.print("Your choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= diets.size()) {
                    pref = diets.get(choice - 1);
                    break;
                } else {
                    System.out.println("Number out of range. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a number.");
            }
        }

        customers.add(new Customer(name, pref));
        System.out.println(" Customer created with preference: " + pref);
    }

    // Display list of customers
    private static void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (int i = 0; i < customers.size(); i++) {
            System.out.printf("%d. %s (%s)\n", i + 1,
                    customers.get(i).getName(), customers.get(i).getDietaryPreference());
        }
    }

    // Place a new order for a customer
    private static void makeOrder() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }

        listCustomers();

        int index = -1;
        while (true) {
            System.out.print("Select customer number: ");
            String input = scanner.nextLine();
            try {
                index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < customers.size()) break;
                else System.out.println("Invalid number. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        Customer customer = customers.get(index);

        System.out.print("Enter ingredients (comma-separated): ");
        String[] input = scanner.nextLine().split(",");
        List<String> ingredients = Arrays.stream(input).map(String::trim).toList();

        boolean valid = IngredientValidator.validate(ingredients, customer.getDietaryPreference());

        if (!valid) {
            System.out.println("Order contains restricted ingredients!");
            Map<String, String> subs = IngredientValidator.suggestSubstitutions(ingredients, customer.getDietaryPreference());
            if (!subs.isEmpty()) {
                System.out.println("Suggested substitutions:");
                subs.forEach((bad, alt) -> System.out.println("- " + bad + " ⟶ " + alt));
            }
            return;
        }

        for (String ing : ingredients) {
            inventory.useIngredient(ing, 1);
        }

        Order order = OrderService.createOrder(customer, ingredients);
        Task task = new Task("Prepare meal for " + customer.getName(), "Chef-" + (tasks.size() + 1));
        tasks.add(task);

        System.out.println("Order placed and assigned to: " + task.getAssignedTo());
    }

    // Show all orders for a specific customer
    private static void viewOrders() {
        if (customers.isEmpty()) {
            System.out.println("No customers.");
            return;
        }

        listCustomers();

        int index = -1;
        while (true) {
            System.out.print("Select customer number: ");
            String input = scanner.nextLine();
            try {
                index = Integer.parseInt(input) - 1;
                if (index >= 0 && index < customers.size()) break;
                else System.out.println("Invalid number. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        Customer customer = customers.get(index);
        List<Order> orders = customer.getOrderHistory();

        if (orders.isEmpty()) {
            System.out.println("No orders for this customer.");
            return;
        }

        for (Order o : orders) {
            System.out.println("- " + o.getIngredients() + " | Valid: " + o.isValid());
        }
    }

    // Get AI-based recipe recommendation
    private static void aiRecommendation() {
        List<String> diets = List.of("vegan", "vegetarian", "keto", "none");

        String pref = "";
        while (true) {
            System.out.println("Choose dietary preference:");
            for (int i = 0; i < diets.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, diets.get(i));
            }
            System.out.print("Your choice: ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= diets.size()) {
                    pref = diets.get(choice - 1);
                    break;
                } else {
                    System.out.println(" Number out of range. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a number.");
            }
        }

        System.out.print("Enter available ingredients (comma-separated): ");
        List<String> ingredients = Arrays.stream(scanner.nextLine().split(",")).map(String::trim).toList();

        int time = 0;
        while (true) {
            System.out.print("How many minutes available? ");
            String input = scanner.nextLine();
            try {
                time = Integer.parseInt(input);
                if (time > 0) break;
                else System.out.println(" Time must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println(" Please enter a valid number.");
            }
        }

        String rec = AIAssistant.recommendRecipe(pref, ingredients, time);
        System.out.println("🤖 " + rec);
    }

    // Show stock alerts and generate purchase orders
    private static void checkInventory() {
        System.out.println("🔍 Inventory status:");
        List<String> items = List.of("pasta", "tomatoes", "basil", "cheese", "meat");

        for (String item : items) {
            int qty = inventory.getQuantity(item);
            if (inventory.isLow(item)) {
                NotificationService.notifyUser(" Low stock: " + item + " (" + qty + ")");
                PurchaseOrder po = new PurchaseOrder(item, 10);
                purchaseOrders.add(po);
                System.out.println(" Purchase order generated: " + po);
            } else {
                System.out.println( item + " available: " + qty);
            }
        }
    }

    // Show all assigned kitchen tasks
    private static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned.");
        } else {
            System.out.println("📋 Task list:");
            for (Task task : tasks) {
                System.out.println("- " + task);
            }
        }
    }
}