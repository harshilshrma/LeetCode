// 1 May 2024
// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
// and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that
// should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

package Easy;

import java.util.Arrays;

public class lc0088_MergeSortedArray {
    public long[] mergeBRUTE(int[] nums1, int m, int[] nums2, int n) {
        int l = 0, r = 0, idx = 0;
        int[] nums = new int[m + n];

        while (l < m && r < n) {
            if (nums1[l] <= nums2[r]) {
                nums[idx++] = nums1[l++];
            } else {
                nums[idx++] = nums2[r++];
            }
        }

        while (l < m) {
            nums[idx++] = nums1[l++];
        }

        while (r < n) {
            nums[idx++] = nums2[r++];
        }

        for (int i = 0; i < m + n; i++) {
            if (i < n) nums1[i] = nums[i];
            else nums1[i] = nums[i];
        }

        System.out.println(Arrays.toString(nums1));

        return new long[0];
    }

    public long[] mergeOPTIMAL1(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = 0;

        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }

            Arrays.sort(nums1);
            Arrays.sort(nums2);
        }

        return new long[0];
    }

    // Gap method
    public static void swapIfGreater(int[] nums1, int[] nums2, int idx1, int idx2) {
        if (nums1[idx1] > nums2[idx2]) {
            int temp = nums1[idx1];
            nums1[idx1] = nums2[idx2];
            nums2[idx2] = temp;
        }
    }

    public long[] mergeOPTIMAL2(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;

            while (right < len) {
                // arr1 and arr2
                if (left < n && right >= n) {
                    swapIfGreater(nums1, nums2, left, right - n);
                }
                // arr2 and arr2
                else if (left >= n) {
                    swapIfGreater(nums2, nums2, left - n, right - n);
                }
                // arr1 and arr1
                else {
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }

            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }

        return new long[0];
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0088_MergeSortedArray obj = new lc0088_MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;
        System.out.println(Arrays.toString(obj.mergeBRUTE(nums1, m, nums2, n)));
        System.out.println(Arrays.toString(obj.mergeOPTIMAL1(nums1, m, nums2, n)));
        System.out.println(Arrays.toString(obj.mergeOPTIMAL2(nums1, m, nums2, n)));
    }
}
