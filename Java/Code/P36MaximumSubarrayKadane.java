public class P36MaximumSubarrayKadane {

    public static int maxSubArray(int[] arr) {
        int res = arr[0];  // Initialize result with the first element
        int maxEnd = arr[0];  // Initialize maxEnd (maximum sum ending at the current index) with the first element

        // Loop through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update maxEnd, choosing the maximum between the current element or the sum of current element + maxEnd
            maxEnd = Math.max(maxEnd + arr[i], arr[i]);

            // Update the result (maximum subarray sum so far)
            res = Math.max(res, maxEnd);
        }

        return res;  // Return the maximum subarray sum
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};  // Example input
        System.out.println("Maximum Subarray Sum: " + maxSubArray(arr));  // Output: 10
    }
}
