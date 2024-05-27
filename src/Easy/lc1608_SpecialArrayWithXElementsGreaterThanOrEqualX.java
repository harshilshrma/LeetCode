// 27-05-2024 - 01:00 pm
// You are given an array nums of non-negative integers. nums is considered special if there exists a number x such that there are exactly x numbers in nums that are greater than or equal to x.
//
//Notice that x does not have to be an element in nums.
//
//Return x if the array is special, otherwise, return -1. It can be proven that if nums is special, the value for x is unique.

package Easy;

public class lc1608_SpecialArrayWithXElementsGreaterThanOrEqualX {
    // Functions
    public int check(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= mid) count++;
        }

        if (count == mid) return 0;
        else if (count > mid) return -1;
        else return 1;
    }

    public int specialArray(int[] nums) {
        int low = 0, high = nums.length, ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (check(nums, mid) == 0) {
                ans = mid;
                break;
            } else if (check(nums, mid) == -1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans == 0 ? -1 : ans;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc1608_SpecialArrayWithXElementsGreaterThanOrEqualX obj = new lc1608_SpecialArrayWithXElementsGreaterThanOrEqualX();
        System.out.println(obj.specialArray(new int[]{0, 4, 3, 0, 4}));
        System.out.println(obj.specialArray(new int[]{3, 5}));
        System.out.println(obj.specialArray(new int[]{0, 0}));
    }
}



