class P71Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test cases
        String test1 = "babad";
        String test2 = "cbbd";
        String test3 = "a";
        String test4 = "ac";
        
        // Running the method
        System.out.println("Longest palindrome in 'babad': " + solution.longestPalindrome(test1));
        System.out.println("Longest palindrome in 'cbbd': " + solution.longestPalindrome(test2));
        System.out.println("Longest palindrome in 'a': " + solution.longestPalindrome(test3));
        System.out.println("Longest palindrome in 'ac': " + solution.longestPalindrome(test4));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        
        int start = 0, maxLength = 1;
        
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            
            if (len > maxLength) {
                start = i - (len - 1) / 2;
                maxLength = len;
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
