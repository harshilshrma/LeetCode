// Date: 27 December 2023
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
// There is only one repeated number in nums, return this repeated number.
// You must solve the problem without modifying the array nums and uses only constant extra space.

package Medium;
public class lc0287_FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = 0;
        do {
            slow = nums[slow];
            slow2 = nums[slow2];
        } while (slow != slow2);

        return slow;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0287_FindTheDuplicateNumber obj = new lc0287_FindTheDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(obj.findDuplicate(nums));
    }
}