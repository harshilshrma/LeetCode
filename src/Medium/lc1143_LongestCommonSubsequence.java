// Date: 25 January 2024
// Given two strings text1 and text2, return the length of their longest common subsequence. If there is no
// common subsequence, return 0.
//A subsequence of a string is a new string generated from the original string with some characters (can be none)
// deleted without changing the relative order of the remaining characters.
//For example, "ace" is a subsequence of "abcde".
//A common subsequence of two strings is a subsequence that is common to both strings.

package Medium;

public class lc1143_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // Fill the dynamic programming table
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // Characters match, extend the common subsequence
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    // Characters don't match, consider the maximum length obtained by excluding a character
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        // Return the length of the longest common subsequence
        return dp[0][0];
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1143_LongestCommonSubsequence obj = new lc1143_LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }
}
