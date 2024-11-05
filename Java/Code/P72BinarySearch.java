public class P72BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        // Define the left and right pointers
        int left = 0, right = arr.length - 1;

        // Loop until the two pointers meet
        while (left <= right) {
            // Calculate the middle index
            int mid = (left + right) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid;  // Target found at index mid
            }

            // If the target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }

            // If the target is smaller, ignore the right half
            else {
                right = mid - 1;
            }
        }

        // Return -1 if the target is not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;

        int result = binarySearch(arr, target);
        if (result != -1) {
            System.out.println("Target found at index " + result);
        } else {
            System.out.println("Target not found");
        }
    }
}
