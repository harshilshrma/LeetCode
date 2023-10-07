//// Date: 09 September 2023
//// Q35: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
//// and j != k, and nums[i] + nums[j] + nums[k] == 0.
//// Notice that the solution set must not contain duplicate triplets.
//
//package Medium;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Q35_3Sum {
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        List<List<Integer>> list_out = new ArrayList<>();
//        List<List<Integer>> list_in = new ArrayList<>();
//
//        System.out.println(Arrays.toString(nums));
//        int l = 0;
//        int r = nums.length - 1;
//        int m = nums.length / 2;
//        while (l < m) {
//            int sum = nums[l] + nums[m] + nums[r];
//            if (sum <= 0) {
//
//            } else if () {
//
//            }
//            else {
//
//            }
//        }
//
//
//        return list;
//    }
//
//    public static void main(String[] args) {
//        Q35_3Sum obj = new Q35_3Sum();
//        int[] arr = {-1, 0, 1, 2, -1, -4};
//        System.out.println(obj.threeSum(arr));
//    }
//}
