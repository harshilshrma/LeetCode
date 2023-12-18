// Date: 18 December 2023
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.

package Medium;

import java.util.Arrays;

public class lc0567_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int n = s1.length();
        int m = s2.length();

        // Counting the number of occurrence of each character in s1
        for (int i = 0; i < n; i++) {
            s1Count[s1.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(s1Count));
        System.out.println("\n");

        for (int i = 0; i < m; i++) {
            // Counting the number of occurrence of each character in s2
            s2Count[s2.charAt(i) - 'a']++;

            // Checking if the window in s2 has reached the length of s1 (i >= n)
            if (i >= n){
                // Decrementing the count of the character that was at the start of the window
                // to keep shifting the window in lengths of size of s1 (n)
                s2Count[s2.charAt(i - n) - 'a']--;
            }

            System.out.println(Arrays.toString(s2Count));

            // Checking if the current window in s2 has the same character frequencies as s1
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        lc0567_PermutationInString obj = new lc0567_PermutationInString();
        String s1 = "ab";
        String s2 = "bcabc";
        System.out.println(obj.checkInclusion(s1, s2));
    }
}
