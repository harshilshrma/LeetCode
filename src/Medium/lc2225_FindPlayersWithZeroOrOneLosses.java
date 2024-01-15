// Date: 15 January 2024
// You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player
// winneri defeated player loseri in a match.
//Return a list answer of size 2 where:

//answer[0] is a list of all players that have not lost any matches.
//answer[1] is a list of all players that have lost exactly one match.
//The values in the two lists should be returned in increasing order.

//Note:

//You should only consider the players that have played at least one match.
//The testcases will be generated such that no two matches will have the same outcome.

package Medium;

import java.util.*;

public class lc2225_FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        // HashMap to store the count of losses for each player
        HashMap<Integer, Integer> lostMap = new HashMap<>();

        // Lists to store players who have not lost and those who lost only once
        List<Integer> notLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        // List to store the final result
        List<List<Integer>> ans = new ArrayList<>();

        // Count the losses for each player
        for (int i = 0; i < matches.length; i++) {
            int looser = matches[i][1];
            lostMap.put(looser, lostMap.getOrDefault(looser, 0) + 1);
        }

        // Iterate through the matches to identify winners and update the lostMap
        for (int i = 0; i < matches.length; i++) {
            int looser = matches[i][1];
            int winner = matches[i][0];

            // If the winner is not in the lostMap, add them to the notLost list and mark them as -1 in lostMap
            if (!lostMap.containsKey(winner)) {
                notLost.add(winner);
                lostMap.put(winner, -1);
            }

            // If the looser has lost only once, add them to the lostOnce list
            if (lostMap.get(looser) == 1) {
                lostOnce.add(looser);
            }
        }

        // Sort the notLost and lostOnce lists
        Collections.sort(notLost);
        Collections.sort(lostOnce);

        // Add the lists to the final result
        ans.add(notLost);
        ans.add(lostOnce);

        // Return the final result
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2225_FindPlayersWithZeroOrOneLosses obj = new lc2225_FindPlayersWithZeroOrOneLosses();
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        int[][] matches1 = {{2,3},{1,3},{5,4}, {6,4}};
        System.out.println(obj.findWinners(matches));
        System.out.println(obj.findWinners(matches1));
    }
}