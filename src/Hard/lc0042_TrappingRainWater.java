// Date: 09 December 2023
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.

package Hard;

import java.util.Arrays;

public class lc0042_TrappingRainWater {
    public int trap(int[] height) {

        // Brute Force (using Arrays)
//        int[] maxLeft = new int[height.length];
//        int[] maxRight = new int[height.length];
//        maxLeft[0] = height[0];
//        maxRight[maxRight.length - 1] = height[height.length - 1];
//
//        for (int i = 1; i < height.length; i++) {
//            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
//        }
//
//        for (int i = maxRight.length - 2; i >= 0; i--) {
//            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
//        }
//
//        int water = 0;
//        for (int i = 0; i < height.length; i++) {
//            water += (Math.min(maxLeft[i], maxRight[i]) - height[i]);
//        }
//
//        return water;

        // Optimal (Using Two Pointers)
        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int water = 0;

        while (l < r) {
            if (maxLeft < maxRight) {
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                water += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                water += maxRight - height[r];
            }
        }
        return water;
    }

    public static void main(String[] args) {
        lc0042_TrappingRainWater obj1 = new lc0042_TrappingRainWater();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2 = {4,2,0,3,2,5};
        System.out.println(obj1.trap(arr));
    }
}