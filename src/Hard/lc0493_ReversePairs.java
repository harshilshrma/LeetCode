// 2 May 2024
// Given an integer array nums, return the number of reverse pairs in the array.
//
//A reverse pair is a pair (i, j) where:
//
//0 <= i < j < nums.length and
//nums[i] > 2 * nums[j].

package Hard;

import java.util.ArrayList;

public class lc0493_ReversePairs {

    public static void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Merge two sorted halves into a temporary list
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        // Copy remaining elements from left half, if any
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        // Copy remaining elements from right half, if any
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        // Copy sorted elements from temporary list back to original array
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;

        // Count pairs satisfying the condition nums[i] > 2 * nums[j]
        for (int i = low; i <= mid; i++) {
            while (right <= high && nums[i] > 2L * nums[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }

    public static int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low >= high) return count; // Base case: If the array has one or fewer elements, it's already sorted
        int mid = (low + high) / 2;

        // Recursively sort the left and right halves
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        // Count pairs before merging the sorted halves
        count += countPairs(nums, low, mid, high);

        // Merge the sorted halves
        merge(nums, low, mid, high);
        return count;
    }

    public int reversePairs(int[] nums) {
        // Call mergeSort to count the number of reverse pairs
        return mergeSort(nums, 0, nums.length - 1);
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0493_ReversePairs obj = new lc0493_ReversePairs();
//        int[] nums = {2, 4, 3, 5, 1};
        int[] nums = {2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647};
        System.out.println(obj.reversePairs(nums));
    }
}
