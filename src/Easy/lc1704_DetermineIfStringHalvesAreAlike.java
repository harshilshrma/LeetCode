// Date: 12 January 2024
// You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the
// first half and b be the second half.
//Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
// Notice that s contains uppercase and lowercase letters.
//Return true if a and b are alike. Otherwise, return false.

package Easy;

public class lc1704_DetermineIfStringHalvesAreAlike {

    // Function to test for vowels
    public boolean checkVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

    // Function to check if the two halves of a string have an equal number of vowels
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2;
        int count1 = 0, count2 = 0;

        // Split the string into two halves
        String firstPart = s.substring(0, mid);
        String secondPart = s.substring(mid);

        // Iterate through the first half and count vowels
        for (int i = 0; i < mid; i++) {
            boolean check1 = checkVowel(firstPart.charAt(i));
            if (check1) count1++;

            // Iterate through the second half and count vowels
            boolean check2 = checkVowel(secondPart.charAt(i));
            if (check2) count2++;
        }

        // Check if the counts of vowels in both halves are equal
        return (count1 == count2);
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1704_DetermineIfStringHalvesAreAlike obj = new lc1704_DetermineIfStringHalvesAreAlike();
        String s = "book";
        System.out.println(obj.halvesAreAlike(s));
    }
}
