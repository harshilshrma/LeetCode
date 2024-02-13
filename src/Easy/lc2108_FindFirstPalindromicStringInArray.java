// Date: 13 February 2024
// Given an array of strings words, return the first palindromic string in the array. If there is no such
// string, return an empty string "".
//
//A string is palindromic if it reads the same forward and backward.

package Easy;

public class lc2108_FindFirstPalindromicStringInArray {

    public String firstPalindrome(String[] words) {
        // Iterate through each word in the array
        for (String s : words) {
            // Create a StringBuilder to reverse the characters of the word
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            String reversedStr = sb.toString();

            // Check if the original word is equal to the reversed string
            if (s.equals(reversedStr)) {
                return s; // Return the word if it is a palindrome
            }
        }
        return ""; // Return an empty string if no palindrome is found
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2108_FindFirstPalindromicStringInArray obj = new lc2108_FindFirstPalindromicStringInArray();
        String[] words = {"abc", "car", "ada", "racecar", "cool"};
        String[] words2 = {"notapalindrome", "racecar"};
        String[] words3 = {"def", "ghi"};
        System.out.println(obj.firstPalindrome(words));
        System.out.println(obj.firstPalindrome(words2));
        System.out.println(obj.firstPalindrome(words3));
    }
}
