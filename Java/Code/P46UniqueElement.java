import java.util.*;
public class P46UniqueElement {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,4,4,4,4};
        HashSet <Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println(set);
        System.out.println(set.size());
    }
}