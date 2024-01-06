// Date: 6 January 2024
// We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit
// of profit[i].
// You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there
// are no two jobs in the subset with overlapping time range.
// If you choose a job that ends at time X you will be able to start another job that starts at time X.

package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc1235_MaximumProfitInJobScheduling {
    int n;

    // Defining a memoization array to store computed results
    int[] memo;

    // Method to find the first job whose startingTime >= currentJobEndTime
    public int getNextIndex(List<List<Integer>> jobs, int l, int currentJobEnd) {
        int r = n - 1;
        int result = n + 1;

        // Binary search to find the next non-overlapping job index
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (jobs.get(mid).get(0) >= currentJobEnd) {
                // This task can be taken, move behind mid in the search
                result = mid;
                r = mid - 1;
            } else {
                // Move ahead in the search
                l = mid + 1;
            }
        }
        return result;
    }

    // Recursive function to solve the job scheduling problem
    public int solve(List<List<Integer>> jobs, int idx) {
        if (idx >= n) {
            return 0;
        }

        // Check if the result is already computed, return if found in memo
        if (memo[idx] != 0) {
            return memo[idx];
        }

        // Finding the index of the next non-overlapping job
        int next = getNextIndex(jobs, idx + 1, jobs.get(idx).get(1));

        // Calculate profit if the current job is taken
        int taken = jobs.get(idx).get(2) + solve(jobs, next);

        // Calculate profit if the current job is not taken
        int notTaken = solve(jobs, idx + 1);

        // Store the computed result in memoization array before returning
        memo[idx] = Math.max(taken, notTaken);
        return memo[idx];
    }

    // Main function to find the maximum profit in job scheduling
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        List<List<Integer>> jobs = new ArrayList<>(); // List to store job details

        // Creating a list of jobs with their start time, end time, and profit
        for (int i = 0; i < n; i++) {
            List<Integer> job =
                    new ArrayList<>(Arrays.asList(startTime[i], endTime[i], profit[i]));
            jobs.add(job);
        }

        // Sorting jobs based on start time to facilitate the scheduling process
        jobs.sort((a, b) -> a.get(0) - b.get(0));

        // Initialize the memoization array with default values
        memo = new int[n];
        Arrays.fill(memo, 0);

        // Calling the solve function to find the maximum profit
        return solve(jobs, 0);
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1235_MaximumProfitInJobScheduling obj = new lc1235_MaximumProfitInJobScheduling();
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};
        System.out.println(obj.jobScheduling(startTime, endTime, profit));
    }
}

