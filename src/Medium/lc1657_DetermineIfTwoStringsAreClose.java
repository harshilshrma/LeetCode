// Date: 14 January 2024
// Two strings are considered close if you can attain one from the other using the following operations:
//Operation 1: Swap any two existing characters.
//For example, abcde -> aecdb

//Operation 2: Transform every occurrence of one existing character into another existing character, and do the
// same with the other character.
//For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

//You can use the operations on either string as many times as necessary.
//Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

package Medium;

import java.util.Arrays;

public class lc1657_DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        // Get the lengths of the input strings
        int m = word1.length();
        int n = word2.length();

        // If the lengths are not equal, the strings cannot be close
        if (m != n) {
            return false;
        }

        // Convert strings to char arrays for easy access
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        // Arrays to store the frequency of each character in both strings
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Iterate through the characters in both strings
        for (int i = 0; i < m; i++) {
            char c1 = arr1[i];
            char c2 = arr2[i];

            // Calculate indices for character frequency arrays
            int idx1 = c1 - 'a';
            int idx2 = c2 - 'a';

            // Update character frequencies
            freq1[idx1]++;
            freq2[idx2]++;
        }

        // Check if characters with non-zero frequency are the same in both strings
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 && freq2[i] != 0) continue;
            if (freq1[i] == 0 && freq2[i] == 0) continue;
            else return false;
        }

        // Sort character frequencies arrays
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        // Check if the sorted character frequencies arrays are equal
        return Arrays.equals(freq1, freq2);
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1657_DetermineIfTwoStringsAreClose obj = new lc1657_DetermineIfTwoStringsAreClose();
        String word1 = "abc";
        String word2 = "bca";
        System.out.println(obj.closeStrings(word1, word2));
    }
}
