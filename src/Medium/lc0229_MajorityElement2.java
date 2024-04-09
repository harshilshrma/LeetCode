// 9 April 2024
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.


package Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class lc0229_MajorityElement2 {
    // Brute-force approach to find majority elements
    public List<Integer> majorityElementBRUTE(int[] v) {
        int n = v.length;
        // HashMap to store counts of elements
        HashMap<Integer, Integer> map = new HashMap<>();
        // List to store majority elements
        List<Integer> list = new ArrayList<>();

        for (int i : v) {
            // Update count of current element
            map.put(i, map.getOrDefault(i, 0) + 1);
            // If count exceeds n/3 and element is not already in list, add it to the list
            if (map.get(i) > n / 3 && !list.contains(i)) {
                list.add(i);
            }
            // If we have found two majority elements, stop iterating
            if (list.size() == 2) break;
        }

        // Sort the list and return
        Collections.sort(list);
        return list;
    }

    // Optimal approach to find majority elements
    public List<Integer> majorityElementOPTIMAL(int[] v) {
        int cnt1 = 0, cnt2 = 0, el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < v.length; i++) {
            // Mark possible numbers
            if (cnt1 == 0 && v[i] != el2) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && v[i] != el1) {
                cnt2 = 1;
                el2 = v[i];
            } else if (el1 == v[i]) cnt1++; // Update count of first possible number
            else if (el2 == v[i]) cnt2++; // Update count of second possible number
            else { // If current number is neither of the possible numbers, decrement counts
                cnt1--;
                cnt2--;
            }
        }

        // Double check the possible answers
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] == el1) cnt1++; // Count occurrences of first possible number
            if (v[i] == el2) cnt2++; // Count occurrences of second possible number
        }

        // If count of any possible number exceeds n/3, add it to the answer list
        if (cnt1 > v.length / 3) ans.add(el1);
        if (cnt2 > v.length / 3) ans.add(el2);

        // Sort the answer list and return
        Collections.sort(ans);
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0229_MajorityElement2 obj = new lc0229_MajorityElement2();
        int[] v = {3, 3, 2};
        System.out.println(obj.majorityElementBRUTE(v));
        System.out.println(obj.majorityElementOPTIMAL(v));
    }
}
