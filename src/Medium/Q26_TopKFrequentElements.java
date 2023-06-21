// Date: June 19, 2023
// Q26: Given an integer array nums and an integer k, return the k most frequent elements. You may return the
// answer in any order.

package Medium;
import java.util.*;

public class Q26_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int count = 0, max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, count);
            }
            map.put(num, map.get(num) + 1);
        }
        System.out.println(map);

        Integer[] keyArray = new Integer[map.size()];
        Integer[] valueArray = new Integer[map.size()];

        int i = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            keyArray[i] = key;
            valueArray[i] = value;
            i++;
        }
        for (i=0; i<map.size(); i++) {
            for (int j=0; j<map.size(); j++) {
                int


            }
        }





        return new int[]{1, 1, 1, 2, 2, 3};
    }

    public static void main(String[] args) {
        Q26_TopKFrequentElements obj1 = new Q26_TopKFrequentElements();
        int k = 3;
        int[] num = new int[]{1, 1, 2, 2, 2, 2, 3, 4, 4};
        obj1.topKFrequent(num, k);

    }

}
