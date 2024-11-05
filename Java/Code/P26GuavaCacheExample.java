import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.concurrent.TimeUnit;

public class P26GuavaCacheExample {
    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(200000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) {
                        return "Value for " + key; // This method will be used if the key is not present in the cache
                    }
                });

        try {
            String[] genres = {"Action", "Comedy", "Drama", "Horror", "Romance", "Sci-Fi", "Thriller"};
            
            // Generate 200,000 movies with random genres and add to cache
            for (int i = 0; i < 200000; i++) {
                String movie = "Movie" + i;
                String genre = genres[new Random().nextInt(genres.length)];
                cache.put(movie, genre);
            }

            // Fetch a specific movie multiple times and measure time taken
            for (int i = 0; i < 100; i++) {
                long startTime = System.nanoTime();
                String movie = cache.get("Movie92600"); // Change the key if needed
                long endTime = System.nanoTime();
                System.out.println("Time taken to fetch the movie: " + (endTime - startTime) + " nanoseconds");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
