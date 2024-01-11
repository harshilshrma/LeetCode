// Date: 11 January 2024
// There are n cars going to the same destination along a one-lane road. The destination is target miles away.
//You are given two integer array position and speed, both of length n, where position[i] is the position of the
// ith car and speed[i] is the speed of the ith car (in miles per hour).
//A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same
// speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is
// ignored (i.e., they are assumed to have the same position).
//A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is
// also a car fleet.
//If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
//Return the number of car fleets that will arrive at the destination.

package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class lc0853_CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        // Check if there is only one car, it will always be a fleet
        if (position.length == 1)
            return 1;

        // Create an array to store pairs of position and speed
        int[][] pairs = new int[position.length][2];

        // Use a stack to keep track of the time each car reaches the destination
        Stack<Double> stack = new Stack<>();

        // Populate the pairs array with position and speed information
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        // Sort the pairs array based on positions in ascending order
        Arrays.sort(pairs, Comparator.comparing(a -> a[0]));

        // Iterate through the sorted pairs in reverse order
        for (int i = pairs.length - 1; i >= 0; i--) {
            // Calculate the time for the current car to reach the destination
            double currentTime = (double) (target - pairs[i][0]) / pairs[i][1];

            // Check if the stack is not empty and the current time is less than or
            // equal to the previous time
            if (!stack.isEmpty() && currentTime <= stack.peek()) {
                // If so, skip to the next iteration
                continue;
            } else {
                // If not, push the current time onto the stack
                stack.push(currentTime);
            }
        }

        // The size of the stack represents the number of car fleets
        // that will arrive at the destination
        return stack.size();
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0853_CarFleet obj = new lc0853_CarFleet();
        int target = 17;
        int[] position = {8,12,16,11,7};
        int[] speed = {6,9,10,9,7};
        System.out.println(obj.carFleet(target, position, speed));
    }
}
