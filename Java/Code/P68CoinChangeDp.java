import java.util.Arrays;

public class P68CoinChangeDP {

    public static int coinChange(int[] coins, int amount) {
        // Create an array dp[] of size amount + 1 and initialize it to a large value (infinity)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);  // We fill with a large number greater than the maximum possible coins
        dp[0] = 0;  // Base case: to make amount 0, we need 0 coins

        // Iterate through each amount from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            // For each coin, update the dp array if the coin can be used to make the current amount 'i'
            for (int coin : coins) {
                if (coin <= i) {
                    // Calculate the minimum coins required for the current amount
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still a large number, return -1 (amount cannot be formed by given coins)
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};  // Example coins
        int amount = 11;          // Example amount
        int result = coinChange(coins, amount);
        
        if (result != -1) {
            System.out.println("Minimum coins required: " + result);
        } else {
            System.out.println("It's not possible to form the amount with the given coins.");
        }
    }
}
