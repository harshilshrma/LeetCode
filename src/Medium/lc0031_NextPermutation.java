// 28 March 2024
// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3],
// [2, 3, 1], [3,1,2], [3,2,1].
//The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
// More formally, if all the permutations of the array are sorted in one container according to their
// lexicographical order, then the next permutation of that array is the permutation that follows it in the
// sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order
// (i.e., sorted in ascending order).
//
//For example, the next permutation of arr = [1,2,3] is [1,3,2].
//Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical
// larger rearrangement.
//Given an array of integers nums, find the next permutation of nums.
//
//The replacement must be in place and use only constant extra memory.

package Medium;

import java.util.Arrays;
import java.util.Collections;

public class lc0031_NextPermutation {
    public int[] nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        // Find the index of the first element from the right that is smaller than its next element
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // If no such element is found, the array is in descending order, so return the sorted array
        if (idx == -1) {
            Arrays.sort(nums);
            return nums;
        }

        int swapIdx = -1;
        // Find the index of the next greater element to swap with the element at idx
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                swapIdx = i;
                break;
            }
        }

        // Swap the elements at idx and swapIdx
        int temp = nums[idx];
        nums[idx] = nums[swapIdx];
        nums[swapIdx] = temp;

        // Sort the elements from idx+1 to the end to get the next permutation
        Arrays.sort(nums, idx + 1, n);
        return nums;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0031_NextPermutation obj = new lc0031_NextPermutation();
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(obj.nextPermutation(nums)));
    }
}
