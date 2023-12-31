// Date: 31 December 2023
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string
// is valid.
// An input string is valid if:
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

package Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lc0020_ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() && (s.charAt(i) == ')' || (s.charAt(i) == '}') || (s.charAt(i) == ']'))){
                return false;
            } else {
                if (s.charAt(i) == ')' && st.peek() == '(') st.pop();
                else if (s.charAt(i) == '}' && st.peek() == '{') st.pop();
                else if (s.charAt(i) == ']' && st.peek() == '[') st.pop();
                else st.add(s.charAt(i));
            }
        }

        // Using HashTable
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)){
                if(!st.isEmpty() && map.get(c).equals(st.peek())){
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0020_ValidParentheses obj = new lc0020_ValidParentheses();
        String s = "()[]{}";
        System.out.println(obj.isValid(s));
    }
}
