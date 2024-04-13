// 13 April 2024
// You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
//
//Return the score of s.

package Easy;

public class lc3110_ScoreOfAString {
    public int scoreOfString(String s) {
        int score = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int ch1 = s.charAt(i);
            int ch2 = s.charAt(i + 1);

            int val = Math.abs(ch1 - ch2);
            score += val;

        }

        return score;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc3110_ScoreOfAString obj = new lc3110_ScoreOfAString();
        String s = "hello";
        System.out.println(obj.scoreOfString(s));
    }
}
