// 8 May 2024
// You are given a sorted array consisting of only integers where every element appears exactly twice,
// except for one element which appears exactly once.
//
//Return the single element that appears only once.
//
//Your solution must run in O(log n) time and O(1) space.

package Medium;

public class lc0540_SingleElementinASortedArray {
    // OBSERVATION
    // ( ) -> pair of same elements
    // (even, odd) -> single element -> (odd, even)

    // (even, odd) means element is in right half -> so left half X
    // (odd, even) means element is in left half -> so right half X

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            //checking the mid first
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // if we are on the odd idx, left shd be even (forming pair)
            // OR
            // if we are on the even idx, right shd be odd (forming pair)
            // -> so we are in the left part and element is in right (so we eliminate left half)
            if ((mid % 2 != 0 && nums[mid - 1] == nums[mid]) || (mid % 2 == 0 && nums[mid + 1] == nums[mid])) {
                low = mid + 1;
            } else {
                // meaning we are on the right half, so we eliminate it
                high = mid - 1;
            }
        }

        return -1;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0540_SingleElementinASortedArray obj = new lc0540_SingleElementinASortedArray();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(obj.singleNonDuplicate(nums));
    }

}
