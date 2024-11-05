import java.util.HashSet;

public class P53LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2}; // Sample input
        System.out.println("Length of Longest Consecutive Subsequence: " + longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : nums) {
            if (!numSet.contains(num - 1)) { // Check if it's the start of a sequence
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) { // Count consecutive numbers
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak); // Update longest streak
            }
        }

        return longestStreak;
    }
}
