import java.util.ArrayList;
import java.util.List;

public class P75LeadersInArray {
    public static void main(String[] args) {
        int[] arr1 = {4, 7, 1, 0};
        int[] arr2 = {10, 22, 12, 3, 0, 6};

        System.out.println("Leaders in arr1: " + findLeaders(arr1));
        System.out.println("Leaders in arr2: " + findLeaders(arr2));
    }

    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;
        int maxFromRight = arr[n - 1]; // Rightmost element is always a leader
        leaders.add(maxFromRight);

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                leaders.add(arr[i]); // Current element is a leader
                maxFromRight = arr[i]; // Update maxFromRight
            }
        }

        // Reverse the leaders list to maintain the order
        List<Integer> orderedLeaders = new ArrayList<>();
        for (int i = leaders.size() - 1; i >= 0; i--) {
            orderedLeaders.add(leaders.get(i));
        }

        return orderedLeaders;
    }
}
