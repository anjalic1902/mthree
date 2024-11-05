public class P69AnagramChecker {
    public static boolean isAnagram(String str1, String str2) {
        // Remove all spaces and convert to lowercase
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // If lengths differ, they can't be anagrams
        if (str1.length() != str2.length()) {
            return false;
        }

        // Array to count character frequencies
        int[] freq = new int[26];  // Assuming only lowercase a-z characters

        // Increment for characters in str1 and decrement for str2
        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i) - 'a']++;
            freq[str2.charAt(i) - 'a']--;
        }

        // Check if all frequencies are zero
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;  // If all counts are zero, it's an anagram
    }

    public static void main(String[] args) {
        String str1 = "Listen";
        String str2 = "Silent";

        if (isAnagram(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }
}
