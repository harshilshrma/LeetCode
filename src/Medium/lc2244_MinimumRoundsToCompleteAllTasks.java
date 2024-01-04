// Date: 4 January 2024
// You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task.
// In each round, you can complete either 2 or 3 tasks of the same difficulty level.
//Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

package Medium;

import java.util.HashMap;

public class lc2244_MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        var counter = new HashMap<Integer, Integer>();
        int ans = 0;

        for (int i : tasks) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        for (int i : counter.values()) {
            if (i == 1) {
                return -1;
            }
            ans += Math.ceil((double) i / 3);
        }
        return ans;
    }
}
