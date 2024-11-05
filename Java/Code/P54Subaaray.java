import java.util.ArrayList;
import java.util.List;

public class P54Subaaray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}; // Sample input
        int targetSum = 6;
        List<int[]> result = findSubarraysWithSum(nums, targetSum);
        
        System.out.println("Subarrays with sum " + targetSum + ":");
        for (int[] subarray : result) {
            System.out.print("[");
            for (int num : subarray) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }

    public static List<int[]> findSubarraysWithSum(int[] nums, int targetSum) {
        List<int[]> subarrays = new ArrayList<>();

        for (int start = 0; start < nums.length; start++) {
            int currentSum = 0;
            for (int end = start; end < nums.length; end++) {
                currentSum += nums[end];
                if (currentSum == targetSum) {
                    int[] subarray = new int[end - start + 1];
                    System.arraycopy(nums, start, subarray, 0, subarray.length);
                    subarrays.add(subarray);
                }
            }
        }

        return subarrays;
    }
}
