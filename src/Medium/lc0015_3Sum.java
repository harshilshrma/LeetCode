// Date: 08 December 2023
// Q35: Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k,
// and j != k, and nums[i] + nums[j] + nums[k] == 0.
// Notice that the solution set must not contain duplicate triplets.

package Medium;

import java.util.*;

public class lc0015_3Sum {

    // Brute-force approach to find all unique triplets
    public List<List<Integer>> threeSumBRUTE(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();

        // Iterate through all possible triplets
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // If the sum of the triplet is zero, add it to the set
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }

        return new ArrayList<>(set); // Convert set to list and return
    }

    // A better approach than brute-force
    public List<List<Integer>> threeSumBETTER(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> ansSet = new HashSet<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                // If the third number is in the set, add the triplet to the answer set
                if (set.contains(third)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(third);
                    Collections.sort(temp);
                    ansSet.add(temp);
                }
                set.add(nums[j]); // Add the current number to the set
            }
        }

        return new ArrayList<>(ansSet); // Convert set to list and return
    }

    // Optimal approach using two-pointer technique
    public List<List<Integer>> threeSumOPTIMAL(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the array
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates
            int j = i + 1;
            int k = n - 1;

            // Use two pointers to find triplets that sum up to zero
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // Add the triplet to the answer list
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);
                    k--;
                    j++;
                    // Skip duplicates
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }

        return ans; // Return the answer list
    }

    public static void main(String[] args) {
        lc0015_3Sum obj = new lc0015_3Sum();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(obj.threeSumBRUTE(arr));
        System.out.println(obj.threeSumBETTER(arr));
        System.out.println(obj.threeSumOPTIMAL(arr));
    }
}
