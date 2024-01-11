// Date: 11 January 2024
// Given an array of integers heights representing the histogram's bar height where the width of each bar
// is 1, return the area of the largest rectangle in the histogram.

package Hard;
import java.util.Stack;

public class lc0084_LargestRectangleInHistogram {
    // For storing the pair(index, height)
    record Pair<K, V> (K key, V value) {};

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        int start;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        // Iterate through the array of heights
        for (int i = 0; i < heights.length; i++) {
            int currHt = heights[i];
            start = i;

            // Process the stack to find the maximum area
            while (!stack.isEmpty() && stack.peek().value() > currHt) {
                Pair<Integer, Integer> pair = stack.pop();
                int index = pair.key();
                int h = pair.value();
                maxArea = Math.max(maxArea, h * (i - index));
                start = index;
            }
            // Push the current height and index onto the stack
            stack.push(new Pair<>(start, currHt));
        }

        // Process the remaining elements in the stack
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int index = pair.key();
            int h = pair.value();
            maxArea = Math.max(maxArea, h * (n - index));
        }

        // Return the maximum area
        return maxArea;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0084_LargestRectangleInHistogram obj = new lc0084_LargestRectangleInHistogram();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(obj.largestRectangleArea(heights));
    }
}