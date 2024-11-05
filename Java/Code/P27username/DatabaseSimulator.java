package P27username;


import java.util.HashMap;
import java.util.Map;

public class DatabaseSimulator {
    private Map<String, Product> database;

    public DatabaseSimulator(int numProducts) {
        database = new HashMap<>();
        // Populate the database with some dummy products
        for (int i = 0; i < numProducts; i++) {
            String id = "PROD" + i;
            database.put(id, new Product(id, "Product " + i, 10.0 + i));
        }
    }

    public class ProductService {
        private final DatabaseSimulator database;
    
        public ProductService(int numProducts) {
            this.database = new DatabaseSimulator(numProducts); // Pass the required argument
        }
    }
    

    public Product getProductById(String id) {
        return database.get(id);
    }
}

