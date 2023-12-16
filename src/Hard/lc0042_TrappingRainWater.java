// Date: 09 December 2023
// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it can trap after raining.

package Hard;

public class lc0042_TrappingRainWater {
    public int trap(int[] height) {
        // For Null input array
        if (height.length == 0) return 0;

        int l = 0;
        int r = height.length - 1;
        int maxLeft = height[l];
        int maxRight = height[r];
        int water = 0;

        while (l < r) {
            if (maxLeft < maxRight){
                l++;
                maxLeft = Math.max(maxLeft, height[l]);
                water += maxLeft - height[l];
            }
            else {
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
        System.out.println(obj1.trap(arr2));
    }
}