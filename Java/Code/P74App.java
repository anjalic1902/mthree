class HashTable<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        table = (Entry<K, V>[]) new Entry[capacity]; // Initialize the table array
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }
        if ((double) size / table.length >= LOAD_FACTOR_THRESHOLD) {
            resize(); // Resize if load factor exceeds threshold
        }
        int index = hash1(key);
        int step = hash2(key);
        int i = 0;

        // Handle collisions using double hashing
        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + step * i) % table.length; // Compute new index
            i++;
        }

        table[index] = new Entry<>(key, value); // Insert key-value pair in the table
        size++;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Null keys are not allowed");
        }

        int index = hash1(key);
        int step = hash2(key);
        int i = 0;

        // Traverse the table until the key is found or an empty slot is encountered
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) { // Call getKey() method correctly
                return table[index].getValue(); // Return the value if the key is found
            }
            index = (index + step * i) % table.length; // Calculate the next index
            i++;
        }

        return null; // Return null if the key is not found
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldTable = table; // Keep a reference to the old table
        table = (Entry<K, V>[]) new Entry[oldTable.length * 2]; // Create a new table with double capacity
        size = 0;

        // Rehash and reinsert all old entries into the new table
        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue()); // Reinsert key-value pairs
            }
        }
    }

    private int hash1(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private int hash2(K key) {
        return 1 + (Math.abs(key.hashCode()) % (table.length - 1));
    }

    // Static inner class to represent an entry in the hash table
    private static class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

// Main application class
public class P74App {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(16); // Initialize hash table with capacity 16

        // Adding key-value pairs to the hash table
        hashTable.put("apple", 1);
        hashTable.put("banana", 2);
        hashTable.put("orange", 3);

        // Retrieve and print value for key "banana"
        System.out.println("Value for banana: " + hashTable.get("banana")); // Output: 2

        // You can also test other key-value pairs
        System.out.println("Value for apple: " + hashTable.get("apple"));   // Output: 1
        System.out.println("Value for orange: " + hashTable.get("orange")); // Output: 3
        System.out.println("Value for mango: " + hashTable.get("mango"));   // Output: null (key not present)
    }
}
