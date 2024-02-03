// Date: 2 February 2024
// An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
// Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc1291_SequentialDigits {

    // Standard Way (Using BFS)
    public List<Integer> sequentialDigitsByBFS(int low, int high) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {
            int temp = q.poll();

            if (temp >= low && temp <= high) {
                ans.add(temp);
            }

            int lastDigit = temp % 10;
            if (lastDigit + 1 <= 9) {
                q.offer(temp * 10 + (lastDigit + 1));
            }
        }
        return ans;
    }

    // Using workaround
    public List<Integer> sequentialDigitsByWorkaround(int low, int high) {
        int[] allPossible = new int[] {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789};
        List<Integer> ans = new ArrayList<>();
        int n = allPossible.length;

        for (int i = 0; i < n; i++) {
             if (allPossible[i] < low) continue;
             if (allPossible[i] > high) continue;

             ans.add(allPossible[i]);
        }
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1291_SequentialDigits obj = new lc1291_SequentialDigits();
        int low = 100, high = 300;
        System.out.println(obj.sequentialDigitsByBFS(low, high));
        System.out.println(obj.sequentialDigitsByWorkaround(low, high));
    }
}