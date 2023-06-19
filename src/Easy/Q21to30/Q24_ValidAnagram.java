// Date: 14 June 2023
// Q24: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
// typically using all the original letters exactly once.

package Easy.Q21to30;

import java.util.Arrays;
public class Q24_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        char arr1[] = new char[l1];
        char arr2[] = new char[l2];
        arr1 = s.toCharArray();
        arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (l1 != l2) return false;

        for (int i=0; i<l1; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
