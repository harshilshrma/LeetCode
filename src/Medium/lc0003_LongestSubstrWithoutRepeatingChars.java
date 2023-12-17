// Date: 17 December 2023
// Given a string s, find the length of the longest substring without repeating characters.

package Medium;

import java.util.*;

public class lc0003_LongestSubstrWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        List<Character> substring = new ArrayList<>();
        int largestLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (substring.contains(s.charAt(right))) {
                // Getting index of the character that is already present in the list
                int index = substring.indexOf(s.charAt(right));

                // Removing the character
                substring.remove(index);

                // Removing all the characters before this repeated character
                if (index > 0){
                    substring.subList(0, index).clear();
                }
            }
            // Adding the next character in line
            substring.add(s.charAt(right));

            // Updating the max length value by comparing it with the current substring's length
            largestLength = Math.max(largestLength, substring.size());
        }
        return largestLength;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0003_LongestSubstrWithoutRepeatingChars obj = new lc0003_LongestSubstrWithoutRepeatingChars();
        String str1 = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(str1));
    }
}
