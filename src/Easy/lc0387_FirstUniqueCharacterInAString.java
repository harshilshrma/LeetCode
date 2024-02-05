// Date: 5 February 2024
// Given a string s, find the first non-repeating character in it and return its index.
// If it does not exist, return -1.

package Easy;

import java.util.HashMap;

public class lc0387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        // HashMap to store character counts
        HashMap<Character, Integer> map = new HashMap<>();

        // Count occurrences of each character in the string
        for (char a : s.toCharArray()) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        // Iterate through the string to find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                // Return the index of the first non-repeating character
                return i;
            }
        }

        // Return -1 if no non-repeating character is found
        return -1;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0387_FirstUniqueCharacterInAString obj = new lc0387_FirstUniqueCharacterInAString();
        String s = "loveleetcode";
        System.out.println(obj.firstUniqChar(s));
    }
}
