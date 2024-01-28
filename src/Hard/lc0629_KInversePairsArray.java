// Date: 27 January 2024
// For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length
// and nums[i] > nums[j].
//Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such
// that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.

package Hard;
import java.util.Arrays;

// Recursive Solution
class RecursiveMethod {
    int mod = 1_000_000_000 + 7;
    int[][] memo;

    // Recursive function to count arrays with k inverse pairs
    public int count(int n, int k) {
        // Base case: if the array length is 0, return 0
        if (n == 0) {
            return 0;
        }

        // Base case: if k is 0, return 1
        if (k == 0) {
            return 1;
        }

        // If the result for the current state is already memoized, return the memoized result
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        int res = 0;
        // For an array of length n, you can have at max (n - 1) inversions
        for (int inv = 0; inv <= Math.min(k, n - 1); inv++) {
            // Calculate the total count recursively by considering different numbers of inverse pairs
            // already have "inv" no. of inversions, now need "k - inv" more
            res = (res % mod + count(n - 1, k - inv) % mod) % mod;
        }

        // Memoize the result for the current state
        memo[n][k] = res;

        // Return the computed result
        return res;
    }

    // Main function to calculate k inverse pairs
    public int kInversePairs(int n, int k) {
        // Initialize the memoization array
        memo = new int[n + 1][k + 1];

        // Fill the memoization array with -1
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }

        // Call the recursive function to compute the result
        return count(n, k);
    }
}


// Bottom Up Approach
class BottomUp {

    // Main function to calculate k inverse pairs
    public int kInversePairs(int n, int k) {
        int mod = 1_000_000_000 + 7;

        // dp[i][j] = total no of arrays having (1 to i) elements and exactly j inversions
        int[][] dp = new int[n + 1][k + 1];

        // Base case: 0 inverse pairs for arrays of any length
        for (int N = 0; N <= n; N++) {
            dp[N][0] = 1;
        }

        // Bottom-Up Iteration
        for (int N = 1; N <= n; N++) {
            for (int K = 1; K <= k; K++) {
                for (int inv = 0; inv <= Math.min(K, N - 1); inv++) {
                    dp[N][K] = (dp[N][K] % mod + dp[N - 1][K - inv] % mod) % mod;
                }
            }
        }

        // Return the final result
        return dp[n][k];
    }
}


// Bottom Up Approach (Optimized)
class BottomUpOpt {
    // Main function to calculate k inverse pairs
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        // Dynamic Programming table to store the number of arrays with a specific number of inverse pairs
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1; // Base case: 0 inverse pairs for arrays of any length

        // Optimized Bottom-Up Iteration
        for (int N = 1; N <= n; N++) {
            int sum = 0; // Variable to store the rolling sum
            for (int K = 0; K <= k; K++) {
                sum += dp[N - 1][K]; // Accumulate the value from the previous row

                // If the current inverse pair count (K) is greater than or equal to the current length (N),
                // subtract the value that goes out of the window
                if (K >= N) {
                    sum -= dp[N - 1][K - N];
                }

                // Handle negative values and take the result modulo the given mod value
                if (sum < 0) sum += mod;
                sum = (sum % mod);

                // Store the computed result in the dynamic programming table
                dp[N][K] = sum;
            }
        }

        // Return the final result
        return (int) (dp[n][k]);
    }
}

public class lc0629_KInversePairsArray {

    // Main function for testing
    public static void main(String[] args) {
        RecursiveMethod obj = new RecursiveMethod();
        BottomUp obj1 = new BottomUp();
        BottomUpOpt obj2 = new BottomUpOpt();
        int n = 1000, k = 1000;
        System.out.println(obj.kInversePairs(n, k));
        System.out.println(obj1.kInversePairs(n, k));
        System.out.println(obj2.kInversePairs(n, k));
    }
}