// Date: June 19, 2023
// Q26: Given an integer array nums and an integer k, return the k most frequent elements. You may return the
// answer in any order.

package Medium;
import java.util.*;

public class Q26_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], count+1);
            }
            map.;
        }
        System.out.println(map);
        int[] numArray = new int[]{1, 1, 1, 2, 2, 3};
        return numArray;
    }

    public static void main(String[] args) {
        Q26_TopKFrequentElements obj1 = new Q26_TopKFrequentElements();
        int k = 3;
        int[] numArray = new int[]{1, 1, 1, 2, 2, 3};
        obj1.topKFrequent(numArray, k);

    }

}
