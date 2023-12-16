// Date: 09 December 2023
// You are given an integer array height of length n. There are n vertical lines drawn such that the
// two endpoints of the ith line are (i, 0) and (i, height[i]).Find two lines that together with the x-axis
// form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

package Medium;

public class lc0011_ContainerWithMostWater {
    public int maxAreaByBruteForce(int[] height) {
        // BRUTE FORCE
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int water = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, water);
            }
        }
        return max;
    }

    // By Two Pointers Method
    public int maxAreaByTwoPointers(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;

        while (l < r) {
            int water = (r - l) * Math.min(height[r], height[l]);
            max = Math.max(max, water);

            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0011_ContainerWithMostWater obj1 = new lc0011_ContainerWithMostWater();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] arr2 = {1, 2};
        int[] arr3 = {2, 3, 10, 5, 7, 8, 9};
        System.out.println(obj1.maxAreaByTwoPointers(arr));
    }
}
