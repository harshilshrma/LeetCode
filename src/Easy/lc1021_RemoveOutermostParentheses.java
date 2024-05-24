// 24-05-2024 - 01:22 pm
// 

package Easy;

public class lc1021_RemoveOutermostParentheses {
    // Functions
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int opened = 0;

        for (char c : s.toCharArray()) {
            if ((c == '(' && opened++ > 0) ||
                    (c == ')' && opened-- > 1)) {
                result.append(c);
                System.out.println(opened + " " + result);
            }
        }

        return result.toString();
    }


    // Main function for testing
    public static void main(String[] args) {
        lc1021_RemoveOutermostParentheses obj = new lc1021_RemoveOutermostParentheses();
        System.out.println(obj.removeOuterParentheses("(()())((()))"));
    }
}



