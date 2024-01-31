// Date: 4 January 2024
// Given an array of integers temperatures represents the daily temperatures, return an array answer such that
// answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no
// future day for which this is possible, keep answer[i] == 0 instead.

package Medium;

import java.util.Arrays;
import java.util.Stack;

public class lc0739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int curDay = 0; curDay < temperatures.length; curDay++) {
            while (!st.isEmpty() && temperatures[curDay] > temperatures[st.peek()]) {

            }
            st.add(temperatures[curDay]);
        }

        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0739_DailyTemperatures obj = new lc0739_DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println((Arrays.toString(obj.dailyTemperatures(temperatures))));
    }

}
