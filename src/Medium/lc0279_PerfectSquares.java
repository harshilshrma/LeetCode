// Date: 8 February 2024
// Given an integer n, return the least number of perfect square numbers that sum to n.
// A perfect square is an integer that is the square of an integer; in other words, it is the product of some
// integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

package Medium;

import java.util.Arrays;

public class lc0279_PerfectSquares {

    // Recursive Approach with Memoization
    int[] arr; // Array to store computed results

    public int helper(int n) {
        if (n == 0) { // Base case: if n is 0, return 0
            return 0;
        }

        if (arr[n] != -1) { // If result for n is already computed, return it
            return arr[n];
        }

        int minCount = Integer.MAX_VALUE; // Initialize minimum count

        for (int i = 1; i * i <= n; i++) { // Iterate through possible perfect squares
            int result = 1 + helper(n - i * i); // Recursive call to find count for reduced value of n
            minCount = Math.min(minCount, result); // Update minCount
        }

        return arr[n] = minCount; // Store and return the minimum count
    }

    public int numSquaresByRecur(int n) {
        arr = new int[10001]; // Initialize array for memoization
        Arrays.fill(arr, -1); // Set all values to -1 (indicating not computed)
        return helper(n); // Call helper function
    }

    // Bottom Up Approach
    public int numSquaresByBU(int n) {
        int[] t = new int[n + 1]; // Array to store minimum number of perfect squares
        Arrays.fill(t, Integer.MAX_VALUE); // Initialize all elements to maximum value
        t[0] = 0; // Base case: 0 requires 0 perfect squares

        for (int i = 1; i <= n; i++) { // Iterate through each index
            for (int j = 1; j * j <= i; j++) { // Iterate through perfect squares <= i
                t[i] = Math.min(t[i],  1 + t[i - j*j]); // Update t[i] with minimum count
            }
        }
        return t[n]; // Return minimum count for n
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0279_PerfectSquares obj = new lc0279_PerfectSquares();
        int n = 12;
        System.out.println(obj.numSquaresByBU(n));
    }
}
