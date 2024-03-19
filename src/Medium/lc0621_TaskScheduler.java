// Date: 19 March 2024
// You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
// Each cycle or interval allows the completion of one task. Tasks can be completed in
// any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
// Return the minimum number of intervals required to complete all tasks.

package Medium;

import java.util.*;

public class lc0621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        // Create an array to store the frequency of each task
        int[] map = new int[26];

        // Count the frequency of each task and store it in the array
        for (char c : tasks) {
            map[c - 'A']++;
        }

        // Initialize the time counter
        int time = 0;

        // Create a priority queue to store the frequencies in descending order
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        // Add the frequencies of tasks to the priority queue
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                q.offer(map[i]);
            }
        }

        // Continue until the priority queue is empty
        while (!q.isEmpty()) {
            // Create a temporary list to store frequencies that have been processed
            ArrayList<Integer> temp = new ArrayList<>();

            // Process tasks for a time interval of n + 1
            for (int i = 1; i <= n + 1; i++) {
                if (!q.isEmpty()) {
                    // Retrieve the frequency of the next task
                    int freq = q.poll();
                    freq--;
                    // Add the updated frequency to the temporary list
                    temp.add(freq);
                }
            }

            // Restore processed frequencies back to the priority queue
            for (int i : temp) {
                if (i > 0) {
                    q.offer(i);
                }
            }

            // If the priority queue is empty, add the size of the temporary list to the time counter
            // Otherwise, add n + 1 to the time counter
            if (q.isEmpty()) {
                time += temp.size();
            } else {
                time += n + 1;
            }
        }

        // Return the total time taken
        return time;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0621_TaskScheduler obj = new lc0621_TaskScheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(obj.leastInterval(tasks, n));
    }
}
