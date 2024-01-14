// Date: 14 January 2024
// Two strings are considered close if you can attain one from the other using the following operations:
//Operation 1: Swap any two existing characters.
//For example, abcde -> aecdb

//Operation 2: Transform every occurrence of one existing character into another existing character, and do the
// same with the other character.
//For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

//You can use the operations on either string as many times as necessary.
//Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

package Medium;

public class lc1657_DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {



        return true;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1657_DetermineIfTwoStringsAreClose obj = new lc1657_DetermineIfTwoStringsAreClose();
        String word1 = "abc";
        String word2 = "bca";
        System.out.println(obj.closeStrings(word1, word2));
    }
}
