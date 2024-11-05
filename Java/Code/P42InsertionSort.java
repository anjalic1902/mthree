public class P42InsertionSort {
    // Method to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element (index 1) since the first is already "sorted"
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // Current element to be inserted in the sorted part
            int j = i - 1;

            // Move elements of the sorted part that are greater than the key
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key in its correct position
            arr[j + 1] = key;
        }
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6};

        System.out.println("Original Array:");
        printArray(arr);

        // Call insertionSort method
        insertionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}

