// Date: 10 March 2024
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the
// result must be unique and you may return the result in any order.

package Easy;

import java.util.*;

public class lc0349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                resultList.add(num);
                map.remove(num);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0349_IntersectionOfTwoArrays obj = new lc0349_IntersectionOfTwoArrays();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        System.out.println(Arrays.toString(obj.intersection(nums1, nums2)));
    }
}
