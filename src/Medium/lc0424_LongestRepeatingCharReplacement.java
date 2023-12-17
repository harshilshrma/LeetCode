// Date: 17 December 2023
// You are given a string s and an integer k. You can choose any character of the string and change it to any other
// uppercase English character. You can perform this operation at most k times.
// Return the length of the longest substring containing the same letter you can get after performing the
// above operations.

package Medium;

public class lc0424_LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {


        return 0;
    }

    public static void main(String[] args) {
        lc0424_LongestRepeatingCharReplacement obj = new lc0424_LongestRepeatingCharReplacement();
        String s = "ABAB";
        int k = 2;
        System.out.println(obj.characterReplacement(s, k));
    }
}
