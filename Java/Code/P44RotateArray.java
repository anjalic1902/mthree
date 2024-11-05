import java.util.Arrays;
public class P44RotateArray {

    // Function to rotate the array
    public static void rotate(int[] arr, int steps) {
        // Get the length of the array
        int n = arr.length;

        // Normalize the number of steps (in case it's larger than array size)
        steps = steps % n;

        // Reverse the whole array
        reverse(arr, 0, n - 1);

        // Reverse the first part (0 to steps-1)
        reverse(arr, 0, steps - 1);

        // Reverse the second part (steps to n-1)
        reverse(arr, steps, n - 1);
    }

    // Helper function to reverse a portion of the array
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
// Main function to test the rotation
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int steps = 3; // Number of positions to rotate

        System.out.println("Original Array: " + Arrays.toString(arr));

        rotate(arr, steps);

        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }
}
