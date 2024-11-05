import java.util.LinkedHashMap;
import java.util.Map;

public class P20MovieRecommendationCache {
    /**
     * L1 Cache for storing recent movie recommendations.
     * 
     * Characteristics:
     * 1. Cache size: 100 entries.
     * 2. Access-order iteration (LRU eviction).
     * 3. When the cache exceeds the maximum capacity, the least recently accessed entry is removed.
     * 4. Load factor of 0.75 improves performance.
     */
    private static final int MAX_ENTRIES = 100;
    private final Map<String, String> recentMovieCache =
        new LinkedHashMap<String, String>(MAX_ENTRIES, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_ENTRIES;
            }
        };

    /**
     * L2 Cache for storing popular movie recommendations.
     * 
     * Characteristics:
     * 1. Cache size: 1000 entries.
     * 2. Access-order iteration (LRU eviction).
     * 3. When the cache exceeds the maximum capacity, the least recently accessed entry is removed.
     * 4. Load factor of 0.75 improves performance.
     */
    private static final int MAX_ENTRIES_L2 = 1000;
    private final Map<String, String> popularMovieCache =
        new LinkedHashMap<String, String>(MAX_ENTRIES_L2, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return size() > MAX_ENTRIES_L2;
            }
        };

    /**
     * Adds a movie recommendation to the L1 (recent) cache.
     */
    public void addToRecentMovies(String movie, String recommendation) {
        recentMovieCache.put(movie, recommendation);
    }

    /**
     * Adds a movie recommendation to the L2 (popular) cache.
     */
    public void addToPopularMovies(String movie, String recommendation) {
        popularMovieCache.put(movie, recommendation);
    }

    /**
     * Displays the contents of the recent movie cache.
     */
    public void displayRecentMovies() {
        System.out.println("Recent Movie Cache:");
        for (Map.Entry<String, String> entry : recentMovieCache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    /**
     * Displays the contents of the popular movie cache.
     */
    public void displayPopularMovies() {
        System.out.println("Popular Movie Cache:");
        for (Map.Entry<String, String> entry : popularMovieCache.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        P20MovieRecommendationCache cache = new P20MovieRecommendationCache();

        // Adding elements to recent movie cache (L1)
        cache.addToRecentMovies("Inception", "Mind-bending thriller");
        cache.addToRecentMovies("The Matrix", "Classic sci-fi");
        cache.addToRecentMovies("Interstellar", "Space exploration epic");

        // Adding elements to popular movie cache (L2)
        cache.addToPopularMovies("Titanic", "Epic romance");
        cache.addToPopularMovies("Avatar", "Visually stunning adventure");
        cache.addToPopularMovies("Avengers: Endgame", "Superhero blockbuster");

        // Display contents of both caches
        cache.displayRecentMovies();
        cache.displayPopularMovies();
    }
}

