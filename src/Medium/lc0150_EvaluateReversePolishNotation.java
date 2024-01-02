// Date: 2 January 2024
// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
//Evaluate the expression. Return an integer that represents the value of the expression.
//Note that:
//The valid operators are '+', '-', '*', and '/'.
//Each operand may be an integer or another expression.
//The division between two integers always truncates toward zero.
//There will not be any division by zero.
//The input represents a valid arithmetic expression in a reverse polish notation.
//The answer and all the intermediate calculations can be represented in a 32-bit integer.

package Medium;

import java.util.Stack;

public class lc0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                // Add the last two elements popped from the stack and push the result back
                stack.add(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                // Subtract the last element popped from the second-to-last element and push the result back
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if (token.equals("*")) {
                // Multiply the last two elements popped from the stack and push the result back
                stack.add(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                // Divide the second-to-last element by the last element popped from the stack and push the result back
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                // Convert the token to an integer and push it onto the stack
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0150_EvaluateReversePolishNotation obj = new lc0150_EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(obj.evalRPN(tokens));
    }
}
