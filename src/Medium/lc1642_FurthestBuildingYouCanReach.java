// Date: 17 February 2024
// You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
//
//You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
//
//While moving from building i to building i+1 (0-indexed),
//
//If the current building's height is greater than or equal to the next building's height, you do not need a
// ladder or bricks.
//If the current building's height is less than the next building's height, you can either use one ladder or
// (h[i+1] - h[i]) bricks.
//Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.

package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lc1642_FurthestBuildingYouCanReach {

    // Recursive + Memoization approach (Memory limit exceeded)
    int[][] t;

    public int solve(int idx, int[] heights, int bricks, int ladders) {
        int n = heights.length;

        if (idx == n - 1) {
            return 0;
        }

        if (t[bricks][ladders] != -1) {
            return t[bricks][ladders];
        }

        if (heights[idx] >= heights[idx + 1]) {
            return t[bricks][ladders] = 1 + solve(idx + 1, heights, bricks, ladders);
        } else {
            // now we either need bricks or ladders
            int byBricks = 0;
            int byLadder = 0;
            int diff = heights[idx + 1] - heights[idx];

            if (diff <= bricks) {
                byBricks = 1 + solve(idx + 1, heights, bricks - diff, ladders);
            }

            if (ladders > 0) {
                byLadder = 1 + solve(idx + 1, heights, bricks, ladders - 1);
            }
            return t[bricks][ladders] = Math.max(byLadder, byBricks);
        }
    }

    public int furthestBuildingMLE(int[] heights, int bricks, int ladders) {
        t = new int[bricks + 1][ladders + 1];
        for (int i = 0; i < bricks + 1; i++) {
            Arrays.fill(t[i], -1);
        }

        return solve(0, heights, bricks, ladders);
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // PriorityQueue to store height differences between consecutive buildings
        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);

        int i = 0, diff = 0;
        // Iterate through each pair of consecutive buildings
        for (i = 0; i < heights.length - 1; i++) {
            // Calculate height difference between current and next building
            diff = heights[i + 1] - heights[i];

            // If difference is non-positive, continue to next pair
            if (diff <= 0) {
                continue;
            }

            // Subtract current difference from available bricks
            bricks -= diff;
            // Add current difference to PriorityQueue
            p.offer(diff);

            // If bricks become negative, use ladder to bypass gap
            if (bricks < 0) {
                bricks += p.poll(); // Poll largest difference from PriorityQueue
                ladders--; // Decrease count of available ladders
            }

            // If no more ladders available, break out of loop
            if (ladders < 0) {
                break;
            }
        }

        return i; // Return index of last building reached
    }


    // Main function for testing
    public static void main(String[] args) {
        lc1642_FurthestBuildingYouCanReach obj = new lc1642_FurthestBuildingYouCanReach();
        int[] heights = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        int bricks = 10, ladders = 2;
        System.out.println(obj.furthestBuildingMLE(heights, bricks, ladders));
        System.out.println(obj.furthestBuilding(heights, bricks, ladders));
    }
}
