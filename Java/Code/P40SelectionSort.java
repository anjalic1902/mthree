public class P40SelectionSort {
    // Method to perform selection sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Go through each element of the array
        for (int i = 0; i < n - 1; i++) {
            // Assume the current element is the smallest
            int minIndex = i;

            // Find the smallest element in the rest of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;  // Update minIndex if a smaller element is found
                }
            }

            // Swap the smallest element found with the current element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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
        int[] arr = {29, 10, 14, 37, 13};

        System.out.println("Before Sorting:");
        printArray(arr);

        // Call selectionSort method
        selectionSort(arr);

        System.out.println("After Sorting:");
        printArray(arr);
    }
}

