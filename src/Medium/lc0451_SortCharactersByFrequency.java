// Date: 7 February 2024
// Given a string s, sort it in decreasing order based on the frequency of the characters.
// The frequency of a character is the number of times it appears in the string.
//Return the sorted string. If there are multiple answers, return any of them.

package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lc0451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        // Create a HashMap to store character frequencies
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Count frequencies of characters in the input string
        for (Character c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Create a list of unique characters
        List<Character> sortedChar = new ArrayList<>(charCount.keySet());

        // Sort the characters based on their frequencies in descending order
        Collections.sort(sortedChar, (a, b) -> charCount.get(b) - charCount.get(a));

        // Reconstruct the sorted string
        StringBuilder res = new StringBuilder();
        for (char c : sortedChar) {
            // Append each character the number of times it occurs in the input string
            res.append(String.valueOf(c).repeat(charCount.get(c)));
        }

        return res.toString(); // Return the sorted string
    }

    // Main fucntion for testing
    public static void main(String[] args) {
        lc0451_SortCharactersByFrequency obj = new lc0451_SortCharactersByFrequency();
        String s = "tree";
        String t = "cccaaa";
        String u = "Aabb";
        System.out.println(obj.frequencySort(s));
        System.out.println(obj.frequencySort(t));
        System.out.println(obj.frequencySort(u));
    }
}
