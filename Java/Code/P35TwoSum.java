import java.util.HashMap;
import java.util.Map;

public class P35TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};  
        int target = 17;               

        int[] result = findTwoSum(arr, target);

        if (result != null) {
            System.out.println("Indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No two numbers add up to the target.");
        }
    }

    public static int[] findTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            
            map.put(arr[i], i);
        }

        return null;
    }
}
