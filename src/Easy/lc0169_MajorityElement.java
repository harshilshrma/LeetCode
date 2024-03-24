// Date: 04 March 2023
// Q14: Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.

package Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// My Solution: 2800 ms :_)
public class lc0169_MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length, k = n / 2, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
                if (count > n / 2) return nums[i];
            }
        }
        return 1;
    }
}

// Best Solution: 7 ms
class best {
    public static int majorityElement(int[] nums) {
        return helper(nums, 0, nums[0]);
    }

    static int helper(int[] nums, int si, int ref) {
        int c = 0;
        for (int i = si; i < nums.length; i++) {
            if (nums[i] == ref)
                c++;
            else
                c--;
            if (c == -1)
                return helper(nums, i, nums[i]);
        }
        return ref;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        majorityElement(nums);
    }
}

// Solution using HashMap: 23 ms
class hashmapsol {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int res;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return 0;
    }
}

// Class implementing Moore's Voting Algorithm
class mooresVotingAlgo {
    // Method to find the majority element in the array
    public int majorityElement(int[] nums) {
        // Initialize a counter for the current element and the majority element
        int cnt = 0;
        int el = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the counter is 0, set the current element as the potential majority element
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            }
            // If the current element equals the potential majority element, increment the counter
            else if (nums[i] == el) {
                cnt++;
            }
            // If the current element is different from the potential majority element, decrement the counter
            else {
                cnt--;
            }
        }

        // Count the occurrences of the potential majority element in the array
        int cnt1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) cnt1++;
        }

        // If the occurrences of the potential majority element exceed half the length of the array, return it;
        // otherwise, return -1
        return cnt1 > nums.length / 2 ? el : -1;
    }
}



