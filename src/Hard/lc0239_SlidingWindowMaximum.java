// Date: 19 December 2023
// You are given an array of integers nums, there is a sliding window of size k which is moving from the very
// left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window
// moves right by one position.
// Return the max sliding window.

package Hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class lc0239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Resulting array
        int[] res = new int[nums.length - k + 1];

        // Index for populating the result array.
        int j = 0;

        // Using a linked list as a deque to store indices of elements in 'nums'.
        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // Removing indices that are out of the current window, maintaining the window length
            if(!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }

            // Removing indices of elements smaller than current element because they can never be maximums
            // This leads to a decreasing deque everytime, so that our max can be the 'peekFirst()' or the leftmost
            // index of the deque
            while (!q.isEmpty() && nums[i] > nums[q.peekLast()]) {
                q.pollLast();
            }

            // Adding the current index to the deque
            q.offer(i);

            // Storing the maximum for the current window
            if (i >= k - 1) { // "k - 1" is the length of the window required
                res[j++] = nums[q.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        lc0239_SlidingWindowMaximum obj = new lc0239_SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(obj.maxSlidingWindow(nums, k)));
    }
}
