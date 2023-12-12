// Date: July 21, 2023
// Q27: Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
// elements of nums except nums[i].
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
// You must write an algorithm that runs in O(n) time and without using the division operation.

package Medium.Q16_to_40;
public class Q27_ProdOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // We will solve this problem by creating 2 arrays which calculates the prefix and suffix
        // products relating to a particular element (except that element)
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        int[] ans = new int[n];

        // The prefix product of first element, i.e., at index 0 will be 1 because no element
        // is present before the first element, hence,
        prefixProduct[0] = 1;

        // Similarly, the suffix product of the last element will be 1, because no element is
        // present after the last element, hence,
        suffixProduct[n-1] = 1;

        // Now, a prefix product for an element will be
        // = (Prefix product of the prior element [if any]) * (The prior element itself)
        // Thus:
        for (int i=1; i<n; i++) {
            prefixProduct[i] = prefixProduct[i-1] * nums[i-1];
        }

        // Similarly, a suffix product for an element will be
        // = (Suffix product of the latter element [if any]) * (The latter element itself)
        // Thus:
        for (int i=n-2; i>=0; i--) {
            suffixProduct[i] = suffixProduct[i+1] * nums[i+1];
        }

        // The final result for each element will be = (prefix products) * (suffix products)
        for (int i=0; i<n; i++){
            ans[i] = prefixProduct[i] * suffixProduct[i];
        }
        return ans;
    }

    // Main method for testing
    public static void main(String[] args) {
        Q27_ProdOfArrayExceptSelf obj123 = new Q27_ProdOfArrayExceptSelf();
        int[] nums = {1, 2, 3, -4} ;
        obj123.productExceptSelf(nums);
    }
}
