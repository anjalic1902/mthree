import java.util.LinkedHashMap;
import java.util.Map;

public class P23LRUCache<K,V> extends LinkedHashMap<K,V> {
    private final int capacity;

    public P23LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
        return size() > capacity;
    }


    public static void main(String[] args) {
        P23LRUCache<String, String> cache = new P23LRUCache<>(3);
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println(cache);
        cache.get("key2");
        cache.put("key4", "value4");
        cache.put("key5", "value5");
        System.out.println(cache);
    }
    
    

}
