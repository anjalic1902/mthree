public class P52Stock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4}; // Sample prices
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price; // Update minimum price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // Calculate profit
            }
        }

        return maxProfit;
    }
}
