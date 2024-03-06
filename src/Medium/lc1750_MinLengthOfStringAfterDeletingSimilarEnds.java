// Date: 05 March 2024
// Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the
// following algorithm on the string any number of times:
//
//Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
//Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
//The prefix and the suffix should not intersect at any index.
//The characters from the prefix and suffix must be the same.
//Delete both the prefix and the suffix.
//Return the minimum length of s after performing the above operation any number of times (possibly zero times).

package Medium;

public class lc1750_MinLengthOfStringAfterDeletingSimilarEnds {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char ch = s.charAt(i);
            while (i < j && s.charAt(i) == ch) {
                i++;
            }

            char ch2 = s.charAt(j);
            while (j >= i && s.charAt(j) == ch2) {
                j--;
            }
        }
        return j - i + 1;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1750_MinLengthOfStringAfterDeletingSimilarEnds obj = new lc1750_MinLengthOfStringAfterDeletingSimilarEnds();
        String s = "aabccabba";
        System.out.println(obj.minimumLength(s));
    }
}
