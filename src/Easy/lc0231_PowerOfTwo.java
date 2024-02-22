// Date: 20 February 2024
// Given an integer n, return true if it is a power of two. Otherwise, return false.
// An integer n is a power of two, if there exists an integer x such that n == 2x.

package Easy;

public class lc0231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // Iterate through possible powers of two from 0 to 30
        for (int i = 0; i < 31; i++) {
            // Compute the value of 2 raised to the power of i
            int ans = (int) Math.pow(2, i);

            // If computed value matches n, return true
            if (ans == n) return true;
        }
        // If no match found, return false
        return false;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0231_PowerOfTwo obj = new lc0231_PowerOfTwo();
        int n = 3;
        System.out.println(obj.isPowerOfTwo(n));
    }
}
