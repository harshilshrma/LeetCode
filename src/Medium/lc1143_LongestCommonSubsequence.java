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


        return 0;

    }

    // Main function for testing
    public static void main(String[] args) {
        lc1143_LongestCommonSubsequence obj = new lc1143_LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(obj.longestCommonSubsequence(text1, text2));
    }
}
