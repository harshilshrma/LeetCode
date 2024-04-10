// 10 April 2024
// Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//
//0 <= a, b, c, d < n
//a, b, c, and d are distinct.
//nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.

package Medium;

import java.util.*;

public class lc0018_4Sum {
    // Brute-force approach
    public List<List<Integer>> fourSumBRUTE(int[] nums, int target) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();

        // Iterate through all possible quadruplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = nums[i] + nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        // If the sum of the quadruplet is equal to the target, add it to the set
                        if (sum == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set); // Convert set to list and return
    }

    // A better approach than brute-force
    public List<List<Integer>> fourSumBETTER(int[] nums, int target) {
        int n = nums.length;
        HashSet<List<Integer>> ansSet = new HashSet<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int missing = target - (nums[i] + nums[j] + nums[k]);

                    // If the missing number is in the set, add the quadruplet to the answer set
                    if (set.contains(missing)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(missing);
                        Collections.sort(temp);
                        ansSet.add(temp);
                    }
                    set.add(nums[k]); // Add the current number to the set
                }
            }
        }
        return new ArrayList<>(ansSet); // Convert set to list and return
    }

    // Optimal approach using two-pointer technique
    public List<List<Integer>> fourSumOPTIMAL(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue; // Skip duplicates
                int k = j + 1, l = n - 1;

                // Use two pointers to find quadruplets that sum up to the target
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp); // Add the quadruplet to the answer list
                        k++;
                        l--;

                        // Skip duplicates
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return ans; // Return the answer list
    }



    // Main function for testing
    public static void main(String[] args) {
        lc0018_4Sum obj = new lc0018_4Sum();
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(obj.fourSumBRUTE(nums, target));
        System.out.println(obj.fourSumBETTER(nums, target));
        System.out.println(obj.fourSumOPTIMAL(nums, target));
    }
}
