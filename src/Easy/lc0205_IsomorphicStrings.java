// 2 April 2024
// Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters.
// No two characters may map to the same character, but a character may map to itself.

package Easy;

import java.util.HashMap;

public class lc0205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp1 = new HashMap<>();
        HashMap<Character, Character> mp2 = new HashMap<>();

        int m = s.length();

        for (int i = 0; i < m; i++) {

            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if ((mp1.containsKey(ch1) && mp1.get(ch1) != ch2) ||
                    (mp2.containsKey(ch2) && mp2.get(ch2) != ch1)) {
                return false;
            }

            mp1.put(ch1, ch2);
            mp2.put(ch2, ch1);
        }

        return true;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0205_IsomorphicStrings obj = new lc0205_IsomorphicStrings();
        String s = "egg", t = "add";
        System.out.println(obj.isIsomorphic(s, t));
    }
}
