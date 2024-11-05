
import java.util.HashMap;
import java.util.Map;

class Menu {
    private Map<String, Double> menuItems;
    private Map<String, Double> cache;  // Cache for quick access

    public Menu() {
        menuItems = new HashMap<>();
        cache = new HashMap<>();
        loadMenu();
    }

    // Load menu items into the collection
    private void loadMenu() {
        menuItems.put("Pizza", 8.99);
        menuItems.put("Burger", 5.49);
        menuItems.put("Pasta", 7.29);
        menuItems.put("Salad", 4.99);
    }

    // Get price of a menu item, with simple caching
    public double getPrice(String item) {
        if (cache.containsKey(item)) {
            System.out.println(item + " fetched from cache.");
            return cache.get(item);
        }
        if (menuItems.containsKey(item)) {
            double price = menuItems.get(item);
            cache.put(item, price);  // Store in cache
            return price;
        }
        return -1;  // Item not found
    }

    // Display all menu items
    public void showMenu() {
        System.out.println("---- Menu ----");
        for (Map.Entry<String, Double> entry : menuItems.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }
}

class Order {
    private static int idCounter = 0;
    private int orderId;
    private String itemName;

    public Order(String itemName) {
        this.orderId = ++idCounter;
        this.itemName = itemName;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Item: " + itemName;
    }
}

class Kitchen {
    // Synchronized method to process an order
    public synchronized void prepareOrder(Order order, double price) {
        System.out.println("Preparing " + order.getItemName() + " (Order ID: " + order.getOrderId() + ")");
        try {
            Thread.sleep(2000);  // Simulate time taken to prepare the food
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(order.getItemName() + " is ready! Total price: $" + price);
    }
}

class Waiter extends Thread {
    private String name;
    private Menu menu;
    private Kitchen kitchen;
    private String orderItem;

    public Waiter(String name, Menu menu, Kitchen kitchen, String orderItem) {
        this.name = name;
        this.menu = menu;
        this.kitchen = kitchen;
        this.orderItem = orderItem;
    }

    @Override
    public void run() {
        System.out.println(name + " is taking an order for " + orderItem);
        double price = menu.getPrice(orderItem);

        if (price != -1) {
            Order order = new Order(orderItem);
            kitchen.prepareOrder(order, price);
        } else {
            System.out.println("Sorry, " + orderItem + " is not on the menu.");
        }
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Kitchen kitchen = new Kitchen();

        menu.showMenu();

        // Create multiple waiter threads taking orders
        Waiter waiter1 = new Waiter("Waiter 1", menu, kitchen, "Pizza");
        Waiter waiter2 = new Waiter("Waiter 2", menu, kitchen, "Burger");
        Waiter waiter3 = new Waiter("Waiter 3", menu, kitchen, "Pasta");
        Waiter waiter4 = new Waiter("Waiter 4", menu, kitchen, "Salad");

        // Start threads
        waiter1.start();
        waiter2.start();
        waiter3.start();
        waiter4.start();
    }
}

