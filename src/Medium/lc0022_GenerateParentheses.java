// Date: 3 January 2024
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class lc0022_GenerateParentheses {

    // Stack to track parentheses
    Stack<Character> stack = new Stack<>();
    // List to store generated parentheses combinations
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return ans;
    }

    private void backtrack (int openN, int closedN, int n) {
        // Base condition: When the count of open and closed parentheses equals 'n',
        // add the current combination to the answer list
        if (openN == closedN && closedN == n) {
            // Creating a string from the characters in the stack to represent the combination
            Iterator<Character> val = stack.iterator();
            String temp = "";
            while (val.hasNext()) {
                temp = temp + val.next();
            }
            // Adding the generated combination to the result list
            ans.add(temp);
        }

        // Adding an open parenthesis if the count of open parentheses is less than 'n'
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);

            // Backtracking: Remove the last added open parenthesis to explore other combinations
            stack.pop();
        }

        // Adding a closed parenthesis if the count of closed is less than the count of open
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);

            // Backtracking: Remove the last added closed parenthesis to explore other combinations
            stack.pop();
        }
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0022_GenerateParentheses obj = new lc0022_GenerateParentheses();
        int n = 2;
        System.out.println(obj.generateParenthesis(n));
    }
}