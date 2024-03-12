// Date: 11 March 2024
// You are given two strings order and s. All the characters of order are unique and were sorted in some
// custom order previously.
//
//Permute the characters of s so that they match the order that order was sorted. More specifically, if a
// character x occurs before a character y in order, then x should occur before y in the permuted string.
//
//Return any permutation of s that satisfies this property.


package Medium;

public class lc0791_CustomSortString {
    public String customSortString(String order, String s) {
        // filling the count array
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a'] > 0) {
                res.append(c);
                count[c - 'a']--;
            }
        }

        for (char c : s.toCharArray()) {
            while (count[c - 'a'] > 0) {
                res.append(c);
                count[c - 'a']--;
            }
        }

        return res.toString();
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0791_CustomSortString obj = new lc0791_CustomSortString();
        String order = "bcafg", s = "abcd";
        System.out.println(obj.customSortString(order, s));
    }
}
