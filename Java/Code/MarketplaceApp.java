import java.util.ArrayList;
import java.util.Scanner;

// Product class representing a general product
class Product {
    private String name;
    private String brand;
    private double price;

    // Constructor
    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    // Display product details
    public void displayProduct() {
        System.out.println(name + " | Brand: " + brand + " | Price: $" + price);
    }
}

// Cart class to store selected products
class Cart {
    private ArrayList<Product> cartItems = new ArrayList<>();

    public void addToCart(Product product) {
        cartItems.add(product);
        System.out.println("Added to cart: " + product.getName());
    }

    public void viewCart() {
        System.out.println("\nYour Cart:");
        double totalAmount = 0;
        for (Product product : cartItems) {
            product.displayProduct();
            totalAmount += product.getPrice();
        }
        System.out.println("Total Amount to Pay: $" + totalAmount);
    }
}

// Section class to store and manage products in a section
class Section {
    private String sectionName;
    private ArrayList<Product> products = new ArrayList<>();

    public Section(String sectionName) {
        this.sectionName = sectionName;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        System.out.println("\n" + sectionName + " Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.print((i + 1) + ". ");
            products.get(i).displayProduct();
        }
    }

    public Product getProduct(int index) {
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        return null;
    }
}

// Marketplace class to manage sections and user interactions
public class MarketplaceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        // Create sections
        Section furniture = new Section("Furniture");
        Section electronics = new Section("Electronics");
        Section jewellery = new Section("Jewellery");

        // Add products to furniture section
        furniture.addProduct(new Product("Chair", "IKEA", 50.00));
        furniture.addProduct(new Product("Table", "Woodland", 150.00));

        // Add products to electronics section
        electronics.addProduct(new Product("Fan", "Philips", 75.00));
        electronics.addProduct(new Product("Light", "Syska", 25.00));

        // Add products to jewellery section
        jewellery.addProduct(new Product("Chain", "Tanishq", 200.00));
        jewellery.addProduct(new Product("Bangle", "Kalyan", 180.00));

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to the Marketplace! Choose a section:");
            System.out.println("1. Furniture");
            System.out.println("2. Electronics");
            System.out.println("3. Jewellery");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            Section selectedSection = null;

            switch (choice) {
                case 1:
                    selectedSection = furniture;
                    break;
                case 2:
                    selectedSection = electronics;
                    break;
                case 3:
                    selectedSection = jewellery;
                    break;
                case 4:
                    cart.viewCart();
                    continue;
                case 5:
                    exit = true;
                    System.out.println("Thank you for visiting the Marketplace. Goodbye!");
                    continue;
                default:
                    System.out.println("Invalid choice, please try again.");
                    continue;
            }

            if (selectedSection != null) {
                selectedSection.displayProducts();
                System.out.print("Select a product to add to the cart (enter number): ");
                int productIndex = scanner.nextInt() - 1;
                Product selectedProduct = selectedSection.getProduct(productIndex);

                if (selectedProduct != null) {
                    cart.addToCart(selectedProduct);
                } else {
                    System.out.println("Invalid product selection.");
                }
            }
        }

        scanner.close();
    }
}

