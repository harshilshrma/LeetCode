// Date: 3 February 2024
// Given an integer array arr, partition the array into (contiguous) subarrays of length at most k.
// After partitioning, each subarray has their values changed to become the maximum value of that subarray.
//Return the largest sum of the given array after partitioning. Test cases are generated so that the answer
// fits in a 32-bit integer.

package Medium;

public class lc1043_PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {




        return 0;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1043_PartitionArrayForMaximumSum obj = new lc1043_PartitionArrayForMaximumSum();
        int[] arr = {1,15,7,9,2,5,10};
        int k = 3;
        System.out.println(obj.maxSumAfterPartitioning(arr, k));
    }
}
