// 8 May 2024
// You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition.
// All the scores are guaranteed to be unique.
//
//The athletes are placed based on their scores, where the 1st place athlete has the highest score,
// the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:
//
//The 1st place athlete's rank is "Gold Medal".
//The 2nd place athlete's rank is "Silver Medal".
//The 3rd place athlete's rank is "Bronze Medal".
//For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's
// rank is "x").
//Return an array answer of size n where answer[i] is the rank of the ith athlete.

package Easy;

import java.util.Arrays;

public class lc0506_RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int maxScore = 0, n = score.length;
        String[] ans = new String[n];

        for (int i : score) {
            maxScore = Math.max(maxScore, i);
        }

        int[] scorePosition = new int[maxScore + 1];
        Arrays.fill(scorePosition, -1);

        for (int i = 0; i < n; i++) {
            scorePosition[score[i]] = i;
        }

        int rank = 1;
        for (int i = maxScore; i >= 0; i--) {
            if (scorePosition[i] != -1) {
                if (rank == 1) {
                    ans[scorePosition[i]] = "Gold Medal";
                    rank++;
                } else if (rank == 2) {
                    ans[scorePosition[i]] = "Silver Medal";
                    rank++;
                } else if (rank == 3) {
                    ans[scorePosition[i]] = "Bronze Medal";
                    rank++;
                } else {
                    ans[scorePosition[i]] = Integer.toString(rank);
                    rank++;
                }
            }
        }

        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0506_RelativeRanks obj = new lc0506_RelativeRanks();
        int[] score = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(obj.findRelativeRanks(score)));
    }
}
