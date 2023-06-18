// Date: 04 March 2023
// Q14: Given an array nums of size n, return the majority element.
// The majority element is the element that appears more than ⌊n / 2⌋ times.
// You may assume that the majority element always exists in the array.

package Easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

// My Solution: 2800 ms :_)
public class Q14_MajorityElement {
    public int majorityElement(int[] nums) {
        int n= nums.length, k = n/2, count=0;
        for (int i=0; i<nums.length; i++){
            count = 0;
            for (int j=0; j<nums.length; j++){
                if(nums[i]==nums[j]) count++;
                if(count>n/2) return nums[i];
            }
        }
        return 1;
    }
}

// Best Solution: 7 ms
class best {
    public static int majorityElement(int[] nums) {
        return helper(nums,0,nums[0]);
    }static int helper(int[] nums, int si, int ref){
        int c=0;
        for(int i=si;i<nums.length;i++){
            if(nums[i]==ref)
                c++;
            else
                c--;
            if(c==-1)
                return helper(nums,i,nums[i]);
        }return ref;
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        int[] nums=new int[s.length];
        for(int i=0;i<s.length;i++){
            nums[i]=Integer.parseInt(s[i]);
        }majorityElement(nums);
    }
}

// Solution using HashMap: 23 ms
class hashmapsol {
    public int majorityElement(int[] nums) {
        int countValues = 0;
        int result = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.get(nums[i]) > countValues) {
                result = nums[i];
                countValues++;
            }

        }
        return result;
    }
}


