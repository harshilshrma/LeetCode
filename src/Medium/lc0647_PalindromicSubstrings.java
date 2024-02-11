// Date: 11 February 2024
// Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.

package Medium;

import java.util.Arrays;

public class lc0647_PalindromicSubstrings {

    // Recursive function to check if a substring is a palindrome
    int[][] memo;

    public int check(String s, int i, int j) {
        // Base case: if i exceeds j, substring is empty or single character (always a palindrome)
        if (i > j) {
            return 1;
        }

        // If result for substring s[i:j] is already memoized, return memoized result
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // If characters at indices i and j are equal, recursively check inner substring
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = check(s, i + 1, j - 1);
        }

        // Otherwise, substring is not a palindrome
        return memo[i][j] = 0;
    }

    // Main function to count palindromic substrings in string s
    public int countSubstringsByRecur(String s) {
        int n = s.length();
        int count = 0;

        // Initialize memoization array with -1
        memo = new int[1001][1001];
        for (int i = 0; i < 1001; i++) {
            Arrays.fill(memo[i], -1);
        }

        // Iterate through all possible substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // If substring is a palindrome, increment count
                if (check(s, i, j) == 1) {
                    count++;
                }
            }
        }

        // Return total count of palindromic substrings
        return count;
    }

    // Bottom-up dynamic programming approach to count palindromic substrings
    public int countSubstringsByDP(String s) {
        int n = s.length();

        // Initialize boolean table to store whether substrings are palindromic
        boolean[][] t = new boolean[n][n];

        int count = 0;
        // Iterate over all possible lengths of substrings
        for (int l = 1; l <= n; l++) {
            // Iterate over all possible starting indices i
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;

                // Check if substring is a palindrome based on its length
                if (i == j) { // 1 length
                    t[i][i] = true;
                } else if (i + 1 == j) { // 2 length
                    t[i][j] = s.charAt(i) == s.charAt(j);
                } else { // Length > 2
                    t[i][j] = (s.charAt(i) == s.charAt(j) && t[i + 1][j - 1]);
                }

                // If substring is a palindrome, increment count
                if (t[i][j]) {
                    count++;
                }
            }
        }
        // Return total count of palindromic substrings
        return count;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0647_PalindromicSubstrings obj = new lc0647_PalindromicSubstrings();
        String s = "abc";
        String t = "aaa";
        System.out.println(obj.countSubstringsByRecur(s));
        System.out.println(obj.countSubstringsByDP(s));

    }
}
