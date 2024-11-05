import java.util.*;

class LFUCache<K, V> {
    private final int capacity;
    private Map<K, V> cache;                   // For storing cache data
    private Map<K, Integer> frequencyMap;      // For storing frequency of each key
    private LinkedHashMap<K, Long> accessOrder;  // For maintaining LRU (access time)
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.accessOrder = new LinkedHashMap<>(capacity, 0.75f, true); // accessOrder = true makes it LRU
    }
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        // Increment frequency since the item is accessed
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
        // Update the access time for LRU handling
        accessOrder.put(key, System.nanoTime());
        
        return cache.get(key);
    }
    
    public void put(K key, V value) {
        if (capacity == 0) {
            return; // No capacity, so no caching
        }
        
        if (cache.containsKey(key)) {
            // If key already exists, just update the value and frequency
            cache.put(key, value);
            get(key); // Reuse get method to update frequency and accessOrder
            return;
        }
        // If cache is full, remove the least frequently used (and LRU if tie)
        if (cache.size() >= capacity) {
            evictLFU();
        }
        // Add new key-value pair
        cache.put(key, value);
        frequencyMap.put(key, 1); // Initial frequency is 1
        accessOrder.put(key, System.nanoTime()); // Track access time for LRU
    }
    private void evictLFU() {
        K evictKey = null;
        int minFrequency = Integer.MAX_VALUE;
        long oldestAccessTime = Long.MAX_VALUE;
        // Find the least frequently used key (and LRU if there's a tie)
        for (K key : cache.keySet()) {
            int freq = frequencyMap.getOrDefault(key, 0);
            long accessTime = accessOrder.getOrDefault(key, Long.MAX_VALUE);
            // Compare frequency first, then fallback on access time for LRU
            if (freq < minFrequency || (freq == minFrequency && accessTime < oldestAccessTime)) {
                minFrequency = freq;
                oldestAccessTime = accessTime;
                evictKey = key;
            }
        }
        // Remove the selected key from cache, frequency map, and access order
        if (evictKey != null) {
            cache.remove(evictKey);
            frequencyMap.remove(evictKey);
            accessOrder.remove(evictKey);
        }
    }
    public void displayCache() {
        System.out.println("Cache: " + cache);
        System.out.println("Frequency Map: " + frequencyMap);
        System.out.println("Access Order: " + accessOrder);
    }
}

public class P34LFUCacheDemo {
    public static void main(String[] args) {
        LFUCache<Integer, String> lfuCache = new LFUCache<>(3);
        
        lfuCache.put(1, "A");
        lfuCache.put(2, "B");
        lfuCache.put(3, "C");

        lfuCache.get(1); // Access item 1, frequency increases
        lfuCache.get(1); // Access item 1, frequency increases again
        lfuCache.get(2); // Access item 2, frequency increases

        lfuCache.put(4, "D"); // This will trigger eviction

        lfuCache.displayCache(); // Display the cache contents
    }
}