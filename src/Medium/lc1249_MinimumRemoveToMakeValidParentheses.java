// 6 April 2024
// Given a string s of '(' , ')' and lowercase English characters.
//
//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that
// the resulting parentheses string is valid and return any valid string.
//
//Formally, a parentheses string is valid if and only if:
//
//It is the empty string, contains only lowercase characters, or
//It can be written as AB (A concatenated with B), where A and B are valid strings, or
//It can be written as (A), where A is a valid string.

package Medium;

import java.util.HashSet;
import java.util.Stack;

public class lc1249_MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();

        HashSet<Integer> toRemove = new HashSet<>();
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(')
                st.push(i);
            else if(ch == ')') {
                if(st.isEmpty())
                    toRemove.add(i);
                else
                    st.pop();
            }
        }

        while(!st.isEmpty())
            toRemove.add(st.pop());

        StringBuilder result = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(!toRemove.contains(i))
                result.append(s.charAt(i));
        }

        return result.toString();
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1249_MinimumRemoveToMakeValidParentheses obj = new lc1249_MinimumRemoveToMakeValidParentheses();
        String s = "lee(t(c)o)de)";
        System.out.println(obj.minRemoveToMakeValid(s));
    }
}
