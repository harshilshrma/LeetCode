// Date: 13 December 2023
// Given two string arrays word1 and word2, return true if the two arrays represent the same string,
// and false otherwise.
// A string is represented by an array if the array elements concatenated in order forms the string.

package Easy.Q31_to_40;

import Medium.Q41_FindMinimumInRotatedSortedArray;

public class Q42_CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for(String str : word1){
            sb1.append(str);
        }

        for(String str : word2){
            sb2.append(str);
        }

        return sb1.toString().equals(sb2.toString());
    }

    // Main function for testing
    public static void main(String[] args) {
        Q42_CheckIfTwoStringArraysAreEquivalent obj1 = new Q42_CheckIfTwoStringArraysAreEquivalent();
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(obj1.arrayStringsAreEqual(word1, word2));

    }
}
