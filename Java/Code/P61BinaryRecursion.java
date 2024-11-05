import java.util.*;

public class P61BinaryRecursion {
    
    // Recursive binary search function
    public static int binarySearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1; // base case: target not found
        }
        
        int mid = (low + high) / 2;
        
        // Check if target is present at mid
        if (nums[mid] == target) {
            return mid;
        }
        
        // If target is smaller than mid, search in the left subarray
        if (target < nums[mid]) {
            return binarySearch(nums, target, low, mid - 1);
        }
        
        // Else, search in the right subarray
        return binarySearch(nums, target, mid + 1, high);
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 6, 7, 9, 12, 16, 17};
        int target = 6;
        
        // Initial call to recursive binary search
        int ind = binarySearch(a, target, 0, a.length - 1);
        
        if (ind == -1)
            System.out.println("The target is not present.");
        else
            System.out.println("The target is at index: " + ind);
    }
}
