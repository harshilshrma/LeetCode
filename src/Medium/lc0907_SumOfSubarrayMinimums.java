// Date: 20 January 2024
// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
// Since the answer may be large, return the answer modulo 109 + 7.

package Medium;

import java.util.Stack;

public class lc0907_SumOfSubarrayMinimums {

    // Function to get the Next Smaller Element to the Left (NSL) for each element in the array
    public int[] getNSL(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                res[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(i);
        }
        return res;
    }

    // Function to get the Next Smaller Element to the Right (NSR) for each element in the array
    public int[] getNSR(int[] arr, int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                res[i] = n;
            } else {
                while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                    st.pop();
                }
                res[i] = st.isEmpty() ? n : st.peek();
            }
            st.push(i);
        }
        return res;
    }

    // Function to calculate the sum of minimum subarrays
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // Get the Next Smaller Element to the Left (NSL) and Next Smaller Element to the Right (NSR) arrays
        int[] nsl = getNSL(arr, n);
        int[] nsr = getNSR(arr, n);

        long sum = 0;
        long M = 1000000007;

        // Iterate through each element in the array
        for (int i = 0; i < n; i++) {
            // Calculate the distance to the left smaller element and to the right smaller element
            long ls = (i - nsl[i]) % M;
            long rs = (nsr[i] - i) % M;

            // Calculate the total number of ways to form minimum subarrays with the current element as the minimum
            long totalWays = (ls * rs) % M;

            // Calculate the total sum contribution of the current element to the overall result
            long totalSum = arr[i] * totalWays;

            // Update the total sum
            sum = (sum + totalSum) % M;
        }

        // Return the final result
        return (int) sum;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0907_SumOfSubarrayMinimums obj = new lc0907_SumOfSubarrayMinimums();
        int[] arr = {71,55,82,55};
        System.out.println(obj.sumSubarrayMins(arr));
    }
}
