public class P67FibonacciDP {

    // Function to calculate Fibonacci using dynamic programming
    public static int fibonacci(int n) {
        // Create an array to store the Fibonacci numbers up to n
        int[] dp = new int[n + 1];

        // Base cases for Fibonacci sequence
        dp[0] = 0;  // Fibonacci(0) = 0
        if (n > 0) {
            dp[1] = 1;  // Fibonacci(1) = 1
        }

        // Calculate Fibonacci numbers from 2 to n using the bottom-up approach
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the nth Fibonacci number
        return dp[n];
    }

    // Correct main method signature
    public static void main(String[] args) {
        int n = 10;  // Example input, you can change it to any other value
        System.out.println("Fibonacci of " + n + " is: " + fibonacci(n));
    }
}
