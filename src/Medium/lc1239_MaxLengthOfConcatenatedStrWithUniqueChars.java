// Date: 23 January 2024
// You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr
// that has unique characters.
//Return the maximum possible length of s.
//A subsequence is an array that can be derived from another array by deleting some or no elements without
// changing the order of the remaining elements.


package Medium;

import java.util.ArrayList;
import java.util.List;

public class lc1239_MaxLengthOfConcatenatedStrWithUniqueChars {

    public boolean hasDuplicate(String s1, String s2) {
        int[] arr = new int[26];

        // Check for duplicate characters in s1
        for (char c : s1.toCharArray()) {
            if (arr[c - 'a'] > 0) {
                return true;
            }
            arr[c - 'a']++;
        }

        // Check for duplicate characters in s2
        for (char c : s2.toCharArray()) {
            if (arr[c - 'a'] > 0) {
                return true;
            }
        }
        return false;
    }

    public int solve(int i, List<String> arr, String temp, int n) {
        if (i >= n) {
            return temp.length();
        }

        int include = 0;
        int exclude = 0;

        // Check for duplicates before including the current string
        if (hasDuplicate(arr.get(i), temp)) {
            exclude = solve(i + 1, arr, temp, n);
        } else {
            // Recursively consider both including and excluding the current string
            exclude = solve(i + 1, arr, temp, n);
            include = solve(i + 1, arr, temp + arr.get(i), n);
        }

        // Return the maximum length obtained by including or excluding the current string
        return Math.max(include, exclude);
    }

    public int maxLength(List<String> arr) {
        String temp = "";
        int n = arr.size();
        int i = 0;

        // Call the recursive function to find the maximum length
        return solve(i, arr, temp, n);
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1239_MaxLengthOfConcatenatedStrWithUniqueChars obj = new lc1239_MaxLengthOfConcatenatedStrWithUniqueChars();
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(obj.maxLength(list));
    }
}
