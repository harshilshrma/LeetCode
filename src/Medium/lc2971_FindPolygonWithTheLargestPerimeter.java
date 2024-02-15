// Date: 15 February 2024
// You are given an array of positive integers nums of length n.
//
//A polygon is a closed plane figure that has at least 3 sides. The longest side of a polygon is smaller than
// the sum of its other sides.
//
//Conversely, if you have k (k >= 3) positive real numbers a1, a2, a3, ..., ak where a1 <= a2 <= a3 <= ... <= ak
// and a1 + a2 + a3 + ... + ak-1 > ak, then there always exists a polygon with k sides whose lengths
// are a1, a2, a3, ..., ak.
//
//The perimeter of a polygon is the sum of lengths of its sides.
//
//Return the largest possible perimeter of a polygon whose sides can be formed from nums, or -1 if it is
// not possible to create a polygon.

package Medium;

import java.util.Arrays;

public class lc2971_FindPolygonWithTheLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;

        // Sort the input array in non-decreasing order
        Arrays.sort(nums);

        long perimeter = 0;
        long remSideSum = 0; // Cumulative sum of remaining sides

        // Iterate through each element in the sorted array
        for (int i = 0; i < n; i++) {
            // If current element can potentially form a polygon, update perimeter
            if (nums[i] < remSideSum) {
                perimeter = remSideSum + nums[i];
            }
            // Update cumulative sum of remaining sides
            remSideSum += nums[i];
        }
        // Return the largest perimeter found or -1 if no valid polygon can be formed
        return perimeter == 0 ? -1 : perimeter;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2971_FindPolygonWithTheLargestPerimeter obj = new lc2971_FindPolygonWithTheLargestPerimeter();
        int[] nums = {1, 12, 1, 2, 5, 50, 3};
        System.out.println(obj.largestPerimeter(nums));
    }
}
