// 5 April 2024
// Given a string s of lower and upper case English letters.
//
//A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
//
//0 <= i <= s.length - 2
//s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
//To make the string good, you can choose two adjacent characters that make the string bad and remove them.
// You can keep doing this until the string becomes good.

//Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
//
//Notice that an empty string is also good.

package Easy;

public class lc1544_MakeTheStringGreat {
    public String makeGood(String s) {
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (res.length() > 0 && (ch + 32 == res.charAt(res.length() - 1) || ch - 32 == res.charAt(res.length() - 1))) {
                res.deleteCharAt(res.length() - 1);
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1544_MakeTheStringGreat obj = new lc1544_MakeTheStringGreat();
        String s = "leEeetcode";
        String s1 = "abBAcC";
        System.out.println(obj.makeGood(s));
        System.out.println(obj.makeGood(s1));
    }
}
