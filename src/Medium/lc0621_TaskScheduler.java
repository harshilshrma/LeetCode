// Date: 19 March 2024
// You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n.
// Each cycle or interval allows the completion of one task. Tasks can be completed in
// any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.
// Return the minimum number of intervals required to complete all tasks.

package Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc0621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];

        for (char c : tasks) {
            map[c - 'A']++;
        }

        int time = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                q.offer(map[i]);
            }
        }

        while (!q.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();

            for (int i = 1; i <= n + 1; i++) {
                if (!q.isEmpty()) {
                    int freq = q.poll();
                    freq--;
                    temp.add(freq);
                }
            }

            for (int i : temp) {
                if (i > 0) {
                    q.offer(i);
                }
            }

            if (q.isEmpty()) {
                time += temp.size();
            } else {
                time += n + 1;
            }
        }

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
