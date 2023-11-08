import java.util.*;//Scanner,Map,HashMap

public class InventoryManagementSystem {
    private Map<String, Integer> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addItem(String itemName, int quantity) {
        if (inventory.containsKey(itemName)) {
            int currentQuantity = inventory.get(itemName);
            inventory.put(itemName, currentQuantity + quantity);
        } else {
            inventory.put(itemName, quantity);
        }
    }

    public void updateStock(String itemName, int newQuantity) {
        if (inventory.containsKey(itemName)) {
            inventory.put(itemName, newQuantity);
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Options:");
                System.out.println("1. Add an item to the inventory");
                System.out.println("2. Update stock quantity");
                System.out.println("3. Display current inventory");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter quantity to add: ");
                        int quantityToAdd = scanner.nextInt();
                        ims.addItem(itemName, quantityToAdd);
                        break;
                    case 2:
                        System.out.print("Enter item name: ");
                        String itemToUpdate = scanner.nextLine();
                        System.out.print("Enter new stock quantity: ");
                        int newStockQuantity = scanner.nextInt();
                        ims.updateStock(itemToUpdate, newStockQuantity);
                        break;
                    case 3:
                        ims.displayInventory();
                        break;
                    case 4:
                        System.out.println("Exiting the Inventory Management System.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
    }
}
