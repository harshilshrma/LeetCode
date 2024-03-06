// Date: 03 March 2024
// You start with an initial power of power, an initial score of 0, and a bag of tokens given as an integer
// array tokens, where each tokens[i] donates the value of tokeni.
//
//Your goal is to maximize the total score by strategically playing these tokens. In one move, you can play an
// unplayed token in one of the two ways (but not both for the same token):
//
//Face-up: If your current power is at least tokens[i], you may play tokeni, losing tokens[i] power and
// gaining 1 score.
//Face-down: If your current score is at least 1, you may play tokeni, gaining tokens[i] power and losing 1 score.
//Return the maximum possible score you can achieve after playing any number of tokens.

package Medium;

import java.util.Arrays;

public class lc0948_BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int maxScore = 0;
        int i = 0, j = n - 1;

        Arrays.sort(tokens);

        int score = 0;
        while (i <= j) {
            if (power >= tokens[i]) {
                power -= tokens[i];
                score++;
                i++;
                maxScore = Math.max(maxScore, score);
            } else if (score >= 1) {
                power += tokens[j];
                score--;
                j--;
            } else {
                return maxScore;
            }
        }
        return maxScore;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0948_BagOfTokens obj = new lc0948_BagOfTokens();
        int[] tokens = {200, 100};
        int power = 150;
        System.out.println(obj.bagOfTokensScore(tokens, power));
    }
}
