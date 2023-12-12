// Date: 12 December 2023
// Given an array of integers nums which is sorted in ascending order, and an integer target,
// write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
// You must write an algorithm with O(log n) runtime complexity.

package Easy.Q31to40;

public class Q38_BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (low + high) / 2;

        if (nums) {

        }


        return -1;
    }

    public static void main(String[] args) {
        Q38_BinarySearch obj = new Q38_BinarySearch();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(obj.search(nums, target));

    }
}
