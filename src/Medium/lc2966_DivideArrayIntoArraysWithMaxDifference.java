// Date: 1 February 2024
// You are given an integer array nums of size n and a positive integer k.

//Divide the array into one or more arrays of size 3 satisfying the following conditions:

//Each element of nums should be in exactly one array.
//The difference between any two elements in one array is less than or equal to k.
//Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions,
// return an empty array. And if there are multiple answers, return any of them.


package Medium;

import java.util.Arrays;

public class lc2966_DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        // Sort the array in ascending order
        Arrays.sort(nums);

        // Calculate the number of rows needed for divided subarrays
        int numRows = (int) Math.ceil((double) nums.length / 3);
        // Initialize a 2D array with the required number of rows
        int[][] ans = new int[numRows][3];
        int row = 0;

        // Iterate through the sorted array in steps of 3
        for (int i = 0; i < nums.length; i += 3) {
            // Checking i, i+1, i+2
            if (i + 2 < nums.length && nums[i + 2] - nums[i] > k) {
                // If the condition is not met, return an empty 2D array
                return new int[][]{};
            } else {
                // Store the three elements in the current row of the 2D array
                ans[row][0] = nums[i];
                ans[row][1] = nums[i + 1];
                ans[row][2] = nums[i + 2];
            }
            row++;
        }

        // Return the 2D array representing the divided subarrays
        return ans;
    }


    // Main fucntion for testing
    public static void main(String[] args) {
        lc2966_DivideArrayIntoArraysWithMaxDifference obj = new lc2966_DivideArrayIntoArraysWithMaxDifference();
        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;
        System.out.println(Arrays.deepToString(obj.divideArray(nums, k)));

    }
}

