import java.util.Arrays;

public class P55PrefixSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}; // Sample input
        int[] prefixSum = calculatePrefixSum(nums);

        System.out.println("Original Array: " + Arrays.toString(nums));
        System.out.println("Prefix Sum Array: " + Arrays.toString(prefixSum));

        // Example: Calculate sum of subarray from index 1 to 3 (inclusive)
        int start = 1, end = 3; // subarray: [2, 3, 4]
        int sum = getSubarraySum(prefixSum, start, end);
        System.out.println("Sum of subarray from index " + start + " to " + end + ": " + sum);
    }

    public static int[] calculatePrefixSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1]; // Prefix sum array of size n + 1

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]; // Calculate prefix sum
        }

        return prefixSum;
    }

    public static int getSubarraySum(int[] prefixSum, int start, int end) {
        return prefixSum[end + 1] - prefixSum[start]; // Calculate subarray sum
    }
}
