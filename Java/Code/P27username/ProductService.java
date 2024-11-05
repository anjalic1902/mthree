package P27username;
import P27username.DatabaseSimulator;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;

public class ProductService {
    private final Cache<String, Product> cache;
    private final DatabaseSimulator database;

    public ProductService(int cacheSize, int numProducts) {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(cacheSize)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        this.database = new DatabaseSimulator();  // Correct initialization
    }

    public void printCacheStats() {
        // Implement logic to print cache stats
        // Example:
        System.out.println("L1 Cache Stats: " + l1Cache.stats());
        System.out.println("L2 Cache Stats: " + l2Cache.stats());
    }

    public Product getProduct(String id) {
        // First, try to retrieve from cache
        Product product = cache.getIfPresent(id);
        if (product != null) {
            return product;
        }

        // If not in cache, retrieve from the database and store in cache
        product = database.getProductById(id);
        if (product != null) {
            cache.put(id, product);
        }

        return product;
    }
}
