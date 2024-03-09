// Date: 09 March 2024
// Given two integer arrays nums1 and nums2, sorted in non-decreasing order, return the minimum
// integer common to both arrays. If there is no common integer amongst nums1 and nums2, return -1.
//
//Note that an integer is said to be common to nums1 and nums2 if both arrays have at least one occurrence of
// that integer.

package Easy;

public class lc2540_MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0;
        int commonMin = Integer.MAX_VALUE;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            if (nums1[ptr1] == nums2[ptr2]) {
                commonMin = Math.min(commonMin, nums1[ptr1]);
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            } else {
                ptr2++;
            }
        }

        return commonMin == Integer.MAX_VALUE ? -1 : commonMin;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2540_MinimumCommonValue obj = new lc2540_MinimumCommonValue();
        int[] nums1 = {1, 2, 3, 6}, nums2 = {2, 3, 4, 5};
        System.out.println(obj.getCommon(nums1, nums2));
    }
}
