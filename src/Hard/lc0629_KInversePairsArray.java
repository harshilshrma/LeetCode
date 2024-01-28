// Date: 27 January 2024
// For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length
// and nums[i] > nums[j].
//Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such
// that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.

package Hard;

import java.util.Arrays;

public class lc0629_KInversePairsArray {

    // Main function for testing
    public static void main(String[] args) {
        RecursiveMethod obj = new RecursiveMethod();
        DPSolution obj1 = new DPSolution();
        int n = 3, k = 0;
        System.out.println(obj.kInversePairs(n, k));
        System.out.println(obj1.kInversePairs(n, k));
    }
}

//  Recursive Solution (Time limit exceeded)
class RecursiveMethod {
    int mod = 1_000_000_000 + 7;
    int[][] memo;

    public int count(int n, int k) {
        if (n == 0) {
            return k == 0 ? 1 : 0;
        }
        if (k < 0) {
            return 0;
        }
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + count(n - 1, k - i)) % mod;
        }

        memo[n][k] = res;
        return res;
    }

    public int kInversePairs(int n, int k) {
        memo = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return count(n, k);
    }
}


class DPSolution {

    public int kInversePairs(int n, int k) {



        return 0;
    }

}