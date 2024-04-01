// 1 April 2024
// Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//A word is a maximal
//substring
// consisting of non-space characters only.

package Easy;

public class lc0058_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length(), len = 0;

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c != ' ') {
                len++;
            } else if (len > 0) {
                break;
            }
        }

        return len;

    }

    // Main function for testing
    public static void main(String[] args) {
        lc0058_LengthOfLastWord obj = new lc0058_LengthOfLastWord();
        String s1 = "Hello World";
        String s = "   fly me   to   the moon  ";
        System.out.println(obj.lengthOfLastWord(s1));
        System.out.println(obj.lengthOfLastWord(s));
    }
}
