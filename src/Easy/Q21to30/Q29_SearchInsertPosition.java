// Date: June 23, 2023
// Q29: Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.
// You must write an algorithm with O(log n) runtime complexity.

package Easy.Q21to30;

public class Q29_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int a = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                a = i;
                break;
            }
            else if (nums[i] > target)
            {
                a = i;
                break;
            } else {
                a = nums.length;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Q29_SearchInsertPosition obj1 = new Q29_SearchInsertPosition();
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        System.out.println(obj1.searchInsert(nums, target));
    }
}
