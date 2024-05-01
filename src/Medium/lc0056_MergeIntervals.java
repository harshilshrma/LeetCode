// 30 April 2024
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.

package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lc0056_MergeIntervals {
    public int[][] mergeBRUTE(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Sort intervals based on their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            // If the current interval overlaps with the last merged interval, update the end time
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            // Merge overlapping intervals
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= end) {
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }

            ans.add(Arrays.asList(start, end)); // Add merged interval to the result list
        }

        // Convert List of Lists to a 2D array
        int[][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i][0] = ans.get(i).get(0);
            ansArray[i][1] = ans.get(i).get(1);
        }

        return ansArray;
    }

    public int[][] mergeOPTIMAL(int[][] intervals) {
        int n = intervals.length;
        List<List<Integer>> ans = new ArrayList<>();

        // Sort intervals based on their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            // If the current interval does not overlap with the last merged interval, add it to the result list
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                // If the current interval overlaps with the last merged interval, update the end time
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }
        }

        // Convert List of Lists to a 2D array
        int[][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i][0] = ans.get(i).get(0);
            ansArray[i][1] = ans.get(i).get(1);
        }

        return ansArray;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0056_MergeIntervals obj = new lc0056_MergeIntervals();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(obj.mergeBRUTE(intervals)));
        System.out.println(Arrays.deepToString(obj.mergeOPTIMAL(intervals)));
    }
}
