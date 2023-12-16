// Date: 16 December 2023
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
// The overall run time complexity should be O(log (m+n)).

package Hard;

public class lc0004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;
        int half = (total + 1) / 2;




        var result = 0.0;

        return 2.00000;
    }

    public static void main(String[] args) {
        lc0004_MedianOfTwoSortedArrays obj = new lc0004_MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(obj.findMedianSortedArrays(nums1, nums2));
    }

}