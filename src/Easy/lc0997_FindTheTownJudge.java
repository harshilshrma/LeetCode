// Date: 22 February 2024
// In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is
// secretly the town judge.
//
//If the town judge exists, then:
//
//The town judge trusts nobody.
//Everybody (except for the town judge) trusts the town judge.
//There is exactly one person that satisfies properties 1 and 2.
//You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts
// the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship
// does not exist.
//
//Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

package Easy;

public class lc0997_FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        // Array to keep track of net trust score of each citizen
        int[] count = new int[n + 1];

        // Iterate through each pair (a, b) in the trust array
        for (int[] pair : trust) {
            // Decrement trust score of citizen a and increment trust score of citizen b
            count[pair[0]]--;
            count[pair[1]]++;
        }

        // Iterate through each citizen
        for (int i = 1; i <= n; i++) {
            // If the trust score of a citizen is equal to n - 1, return that citizen as the judge
            if (count[i] == n - 1) {
                return i;
            }
        }

        // If no judge is found, return -1
        return -1;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0997_FindTheTownJudge obj = new lc0997_FindTheTownJudge();
        int n = 3;
        int[][] trust = {{1, 3}, {2, 3}};
        System.out.println(obj.findJudge(n, trust));
    }
}
