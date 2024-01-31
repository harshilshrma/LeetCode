// Date: 4 January 2024
// Given an array of integers temperatures represents the daily temperatures, return an array answer such that
// answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no
// future day for which this is possible, keep answer[i] == 0 instead.

package Medium;

import java.util.Arrays;
import java.util.Stack;

public class lc0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length]; // Array to store waiting days for warmer temperatures
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of temperatures

        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            // Check if the current temperature is higher than temperatures in the stack
            while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
                int prevDay = stack.pop(); // Get the index of the previous temperature
                ans[prevDay] = currDay - prevDay; // Calculate the number of days to wait for a warmer temperature
            }
            stack.add(currDay); // Add the index of the current temperature to the stack
        }
        return ans; // Return the array with waiting days for warmer temperatures
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0739_DailyTemperatures obj = new lc0739_DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println((Arrays.toString(obj.dailyTemperatures(temperatures))));
    }

}
