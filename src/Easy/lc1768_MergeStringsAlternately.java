// Date: 30 December 2023
// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with
// word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
// Return the merged string.

package Easy;

public class lc1768_MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int p1 = 0, p2 = 0;
        StringBuilder str = new StringBuilder();
        
        while (p1 < m || p2 < n) {
            if (p1 < m){
                str.append(word1.charAt(p1++));
            }
            if (p2 < n){
                str.append(word2.charAt(p2++));
            }
        }
        return str.toString();
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1768_MergeStringsAlternately obj = new lc1768_MergeStringsAlternately();
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(obj.mergeAlternately(word1, word2));
    }
}
