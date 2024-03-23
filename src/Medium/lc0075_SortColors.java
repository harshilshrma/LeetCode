// Date: 23 March 2024
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects
// of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.

package Medium;

import java.util.Arrays;

// Brute Force
public class lc0075_SortColors {
    public int[] sortColors(int[] nums) {
        // Initialize variables to count occurrences of 0, 1, and 2, and get the length of the input array
        int c0 = 0, c1 = 0, c2 = 0, n = nums.length;

        // Iterate through the input array to count occurrences of 0, 1, and 2
        for (int i = 0; i < n; i++) {
            // Increment respective count variables based on the value of the current element
            if (nums[i] == 0) c0++;
            else if (nums[i] == 1) c1++;
            else c2++;
        }

        // Update the array with the correct count of 0s, 1s, and 2s by overwriting elements
        // First, overwrite the elements with 0s
        for (int i = 0; i < c0; i++) {
            nums[i] = 0;
        }

        // Next, overwrite the elements with 1s
        for (int i = c0; i < c0 + c1; i++) {
            nums[i] = 1;
        }

        // Finally, overwrite the elements with 2s
        for (int i = c0 + c1; i < n; i++) {
            nums[i] = 2;
        }

        // Return the sorted array
        return nums;
    }

    // - - - - - - - - - - - - - - - -  --  - - -

    // By Dutch's National Flag Algorithm

    // Function to swap elements at indices 'a' and 'b' in the array 'nums'
    public static void swap (int a, int b, int[] nums) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // Function to sort an array of 0s, 1s, and 2s using Dutch National Flag Algorithm
    public int[] sortColorsByDutchAlgo(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(low, mid, nums);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(mid, high, nums);
                high--;
            }
        }
        return nums;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0075_SortColors obj = new lc0075_SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(obj.sortColors(nums)));
        System.out.println(Arrays.toString(obj.sortColorsByDutchAlgo(nums)));
    }
}
