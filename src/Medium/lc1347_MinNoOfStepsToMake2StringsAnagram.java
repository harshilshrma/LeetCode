// Date: 13 January 2024
// You are given two strings of the same length s and t. In one step you can choose any character of t and replace
// it with another character.
//Return the minimum number of steps to make t an anagram of s.
//An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

package Medium;
import java.util.HashMap;

public class lc1347_MinNoOfStepsToMake2StringsAnagram {
    public int minSteps(String s, String t) {
        int ans = 0;

        // Count the frequency of characters in s
        HashMap<Character, Integer> mapS = new HashMap<>();
        for (char c : s.toCharArray()) {
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }

        // Count the frequency of characters in t
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // Iterate through the characters in mapS
        for (char c : mapS.keySet()) {
            int freqS = mapS.get(c);
            int freqT = mapT.getOrDefault(c, 0);

            // If the frequency in t is less than the frequency in s, update the answer
            if (freqT < freqS) {
                ans += freqS - freqT;
            }
        }

        // Return the final result representing the difference in character frequencies
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1347_MinNoOfStepsToMake2StringsAnagram obj = new lc1347_MinNoOfStepsToMake2StringsAnagram();
        String s = "aba";
        String t = "bba";
        System.out.println(obj.minSteps(s, t));
    }
}
