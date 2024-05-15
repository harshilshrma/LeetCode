// 15-05-2024 - 04:43 pm
// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//
//Return the kth positive integer that is missing from this array.

package Easy;

public class lc1539_KthMissingPositiveNumber {
    // Functions
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfMissingNos = arr[mid] - (mid + 1);

            if (noOfMissingNos < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high + 1 + k;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1539_KthMissingPositiveNumber obj = new lc1539_KthMissingPositiveNumber();
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(obj.findKthPositive(arr, k));
    }
}



