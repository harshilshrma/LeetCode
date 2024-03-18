// Date: 18 March 2024
// There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons
// are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal
// diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.
//
//Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis.
// A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the
// number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.
//
//Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

package Medium;

import java.util.Arrays;
import java.util.Comparator;

public class lc0452_MinNumOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int[] prev = points[0];
        int count = 1;

        for (int i = 0; i < n; i++) {
            int currStartPoint = points[i][0];
            int currEndPoint = points[i][1];

            int prevStartPoint = prev[0];
            int prevEndPoint = prev[1];

            if (currStartPoint > prevEndPoint) { // no overlap
                count++;
                prev = points[i];
            } else { // overlap is there
                // overlapping region finding
                prev[0] = Math.max(currStartPoint, prevStartPoint);
                prev[1] = Math.min(currEndPoint, prevEndPoint);
            }
        }
        return count;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0452_MinNumOfArrowsToBurstBalloons obj = new lc0452_MinNumOfArrowsToBurstBalloons();
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(obj.findMinArrowShots(points));
    }
}
