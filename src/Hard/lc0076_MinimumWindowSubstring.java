// Date: 19 December 2023
// Given two strings s and t of lengths m and n respectively, return the minimum window substring
// of s such that every character in t (including duplicates) is included in the window. If there is no such substring,
// return the empty string "". The testcases will be generated such that the answer is unique.

package Hard;

import java.util.HashMap;

public class lc0076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // Edge case:
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();

        // Counting the no. of each character in string t
        for (char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = 0;
        int subStr = 0;
        int minLen = s.length() + 1; // Taking the max value, because our min is definitely going to be lesser

        // Sliding Window Approach
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // Retrieving the char at 'r'
            char c = s.charAt(r);

            // Checking if it is in the map, meaning if it is needed or not
            if (map.containsKey(c)) {
                // Decrementing the count for the character at 'r' in the map, indicating its presence in the window.
                // When the count reaches 0, it signifies that we've found all occurrences of this character required
                // from string 't'.
                map.put(c, map.get(c) - 1);

                // If this character's count in the map = 0, it means we've found all occurrences of this char required
                // from string t
                if (map.get(c) == 0) {
                    matched++;
                }
            }

            // When we have obtained all the matches from the string 't' (totaling to map's size)
            // This means our current window from l to r, contains all the necessary chars from 't'
            while (matched == map.size()) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    subStr = l;
                }

                // Extracting the char at beginning of the window and then shifting the window to the right by +1
                char deleted = s.charAt(l++); // First l is used, then incremented by 1
                if (map.containsKey(deleted)) { // Valuable char that we needed but is now removed because we have to
                    // carry forward the window to the right to properly iterate it to the end of the array

                    // So, matched is decremented to indicate that this character is no longer fully present
                    // in the window.
                    if (map.get(deleted) == 0) {
                        matched--;
                    }

                    // We increment the count of this character in the map (because we aim to make the count 0
                    // and increasing it means that we have to find more of this char to make its count back to 0).
                    // This step represents the removal of this character from the current window to move the window
                    // forward by one position.
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }

    public static void main(String[] args) {
        lc0076_MinimumWindowSubstring obj = new lc0076_MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(obj.minWindow(s, t));
    }
}
