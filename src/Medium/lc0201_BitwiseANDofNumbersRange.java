// Date: 24 February 2024
// Given two integers left and right that represent the range [left, right], return the
// bitwise AND of all numbers in this range, inclusive.

package Medium;

public class lc0201_BitwiseANDofNumbersRange {

    // Approach 1: Bitwise Shift and Count Common Prefix Bits
    public int rangeBitwiseAnd1(int left, int right) {
        int shiftCount = 0;
        // Continue right shifting left and right until they become equal
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }
        // Left shift the left number by the shift count to obtain the result
        return left << shiftCount;
    }

    // Approach 2: Clearing The Least Significant Bits
    public int rangeBitwiseAnd2(int left, int right) {
        while (right > left) {
            // Clear the least significant bit of right
            right = right & (right - 1);
        }
        // Return right after the common prefix bits are found
        return right;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0201_BitwiseANDofNumbersRange obj = new lc0201_BitwiseANDofNumbersRange();
        int left = 5, right = 7;
        System.out.println(obj.rangeBitwiseAnd1(left, right));
        System.out.println(obj.rangeBitwiseAnd2(left, right));
    }
}
