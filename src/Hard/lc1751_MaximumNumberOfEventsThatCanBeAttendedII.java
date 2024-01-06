// Date: 6 January 2024
// You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at
// startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also
// given an integer k which represents the maximum number of events you can attend.
// You can only attend one event at a time. If you choose to attend an event, you must attend the entire event.
// Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other
// ends on the same day.
// Return the maximum sum of values that you can receive by attending events.

package Hard;

import java.util.Arrays;

public class lc1751_MaximumNumberOfEventsThatCanBeAttendedII {
    int n; // Variable to store the number of events

    int[][] memo; // 2D array for memoization, stores maximum value for each event and remaining capacity

    // Function to find the next available index of an event whose start time is after the current event's end time
    public int findNextIndex(int[][] events, int l, int currentEventEnd){
        int r = n - 1;
        int result = n + 1;

        // Binary search to find the next non-overlapping event index
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (events[mid][0] > currentEventEnd){
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    // Recursive function to calculate the maximum value by attending events
    public int solve(int[][] events, int idx, int k){
        if (idx >= n || k == 0) {
            return 0;
        }

        // If the result for the current event and remaining capacity is already computed, return the stored result
        if (memo[idx][k] != 0) {
            return memo[idx][k];
        }

        // Find the next available event index after the current event and calculate the maximum value if the current event is taken
        int next = findNextIndex(events, idx + 1, events[idx][1]);
        int taken = events[idx][2] + solve(events, next, k - 1);

        // Calculate the maximum value if the current event is not taken
        int notTaken = solve(events, idx + 1, k);

        // Store the maximum value achievable for the current event and remaining capacity in the memoization array
        return memo[idx][k] = Math.max(taken, notTaken);
    }

    // Function to find the maximum value within the constraint of attending k events
    public int maxValue(int[][] events, int k) {
        n = events.length; // Initialize the number of events

        // Sort events based on their starting day to maximize value within the k constraint
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Initialize the memoization array with all values set to 0
        memo = new int[n + 1][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, 0);
        }

        // Calculate and return the maximum value achievable by attending events within the k limit
        return solve(events, 0, k);
    }

    // Main function for testing:
    public static void main(String[] args) {
        lc1751_MaximumNumberOfEventsThatCanBeAttendedII obj = new lc1751_MaximumNumberOfEventsThatCanBeAttendedII();
        int[][] events = {{1,1,1},{2,2,2},{3,3,3},{4,4,4}};
        int k = 2;
        System.out.println(obj.maxValue(events, k));
    }
}
