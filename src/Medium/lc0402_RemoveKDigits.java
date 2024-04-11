// 11 April 2024
// Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.

package Medium;

public class lc0402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder result = new StringBuilder(); // Initialize a StringBuilder to act like a stack
        int n = num.length();

        // Iterate through each digit of the input number
        for (int i = 0; i < n; i++) {
            // While the stack is not empty, the last digit in the stack is greater than the current digit,
            // and there are still digits to be removed (k > 0), remove digits from the stack
            while (result.length() > 0 && result.charAt(result.length() - 1) > num.charAt(i) && k > 0) {
                result.deleteCharAt(result.length() - 1); // Remove the last digit from the stack
                k--; // Decrement the count of digits to be removed
            }

            // If the stack is not empty or the current digit is not '0', add the current digit to the stack
            if (result.length() > 0 || num.charAt(i) != '0') {
                result.append(num.charAt(i)); // Append the current digit to the stack
            }
        }

        // Remove remaining digits if there are still digits to be removed (eg. 12345, 11111)
        while (result.length() > 0 && k > 0) {
            result.deleteCharAt(result.length() - 1); // Remove the last digit from the stack
            k--; // Decrement the count of digits to be removed
        }

        // If the stack is empty, return "0"; otherwise, return the string representation of the stack
        return result.length() == 0 ? "0" : result.toString();
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0402_RemoveKDigits obj = new lc0402_RemoveKDigits();
        String num = "1432219";
        int k = 3;
        System.out.println(obj.removeKdigits(num, k));
    }
}
