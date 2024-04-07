// 7 April 2024
// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
//
//The following rules define a valid string:
//
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

package Medium;

import java.util.Arrays;

public class lc0678_ValidParenthesisString {
    static final int UNINITIALIZED = -1; // Define a constant for uninitialized state
    int[][] t = new int[101][101];

    public boolean solve(int idx, int open, String s) {
        int n = s.length();

        if (idx == n) {
            return open == 0;
        }

        if (t[idx][open] != UNINITIALIZED) { // Check if the cell has been initialized
            return t[idx][open] == 1; // Return the boolean interpretation of the memoization value
        }

        boolean isValid = false;

        if (s.charAt(idx) == '*') {
            // if * is replaced by (
            isValid |= solve(idx + 1, open + 1, s);

            // if * is replaced by " "
            isValid |= solve(idx + 1, open, s);

            // if * is replaced by )
            if (open > 0) {
                isValid |= solve(idx + 1, open - 1, s);
            }
        } else if (s.charAt(idx) == '(') {
            isValid |= solve(idx + 1, open + 1, s);
        } else if (open > 0) {
            isValid |= solve(idx + 1, open - 1, s);
        }

        // Store the result in the memoization table
        t[idx][open] = isValid ? 1 : 0; // Store 1 for true, 0 for false

        return isValid;
    }

    public boolean checkValidString(String s) {
        for (int i = 0; i < 101; i++) {
            Arrays.fill(t[i], UNINITIALIZED); // Initialize the memoization table with UNINITIALIZED
        }

        return solve(0, 0, s);
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0678_ValidParenthesisString obj = new lc0678_ValidParenthesisString();
        String s = "**************************************************))))))))))))))))))))))))))))))))))))))))))))))))))";
        System.out.println(obj.checkValidString(s));
    }
}
