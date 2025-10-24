import java.util.*;

class Product {
    int id;
    String name;
    int quantity;
    String location;

    Product(int id, String name, int quantity, String location) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name + " | Qty: " + quantity + " | Location: " + location;
    }
}

public class SupplyChainTracker {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Product> inventory = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== SUPPLY CHAIN TRACKER ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Quantity");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> viewInventory();
                case 3 -> updateQuantity();
                case 4 -> {
                    System.out.println("👋 Exiting program. Goodbye!");
                    return;
                }
                default -> System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine();
        System.out.print("Enter quantity: ");
        int qty = Integer.parseInt(sc.nextLine());
        System.out.print("Enter location: ");
        String loc = sc.nextLine();

        Product p = new Product(nextId++, name, qty, loc);
        inventory.add(p);
        System.out.println("✅ Product added: " + p);
    }

    private static void viewInventory() {
        System.out.println("\n--- Current Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("(No products yet)");
            return;
        }
        for (Product p : inventory) {
            System.out.println(p);
        }
    }

    private static void updateQuantity() {
        if (inventory.isEmpty()) {
            System.out.println("⚠️ No products available to update.");
            return;
        }
        System.out.print("Enter product ID to update: ");
        int id = Integer.parseInt(sc.nextLine());
        Product found = null;
        for (Product p : inventory) {
            if (p.id == id) {
                found = p;
                break;
            }
        }
        if (found == null) {
            System.out.println("⚠️ Product ID not found.");
            return;
        }
        System.out.print("Enter new quantity: ");
        int newQty = Integer.parseInt(sc.nextLine());
        found.quantity = newQty;
        System.out.println("✅ Quantity updated: " + found);
    }
}
