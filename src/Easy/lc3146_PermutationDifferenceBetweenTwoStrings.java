// 13-05-2024 - 03:51 pm
// You are given two strings s and t such that every character occurs at most once in s and t is a permutation of s.
//
//The permutation difference between s and t is defined as the sum of the absolute difference between the index of the occurrence of each character in s and the index of the occurrence of the same character in t.
//
//Return the permutation difference between s and t.

package Easy;

public class lc3146_PermutationDifferenceBetweenTwoStrings {
    // Function
    public int findPermutationDifference(String s, String t) {
        int sum = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            int idx1 = s.indexOf(i);
            int idx2 = t.indexOf(i);

            if (idx1 != -1) {
                sum += Math.abs(idx1 - idx2);
            }
        }

        return sum;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc3146_PermutationDifferenceBetweenTwoStrings obj = new lc3146_PermutationDifferenceBetweenTwoStrings();
        String s = "abcde", t = "edbac";
        System.out.println(obj.findPermutationDifference(s, t));
    }
}



