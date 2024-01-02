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

public class lc0150_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {


        return 0;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0150_EvaluateReversePolishNotation obj = new lc0150_EvaluateReversePolishNotation();
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.println(obj.evalRPN(tokens));
    }
}
