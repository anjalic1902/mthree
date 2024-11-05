public class P41BubbleSort {
    // Method to perform bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // Outer loop to control the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop to perform comparisons and swaps
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if the current element is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original Array:");
        printArray(arr);

        // Call bubbleSort method
        bubbleSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}

