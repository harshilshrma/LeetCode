// Date: July 08, 2023
// Q31: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
// all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
// and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

package Easy.Q31to40;

public class Q32_ValidPalindrome {
    public boolean isPalindrome(String str) {
        if (str.length() == 0 || str.length() == 1) return true;

        String a = str.toLowerCase();
        StringBuilder joinedStr = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != ' ') {
                if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z') {
                    joinedStr.append(a.charAt(i));
                }
                if (Character.isDigit(str.charAt(i))) {
                    joinedStr.append(a.charAt(i));
                }
            }
        }

//        String originalStr = joinedStr.toString();
//        String reversedStr = joinedStr.reverse().toString();

        System.out.println(joinedStr);
        StringBuilder reversedString = new StringBuilder(joinedStr);
        reversedString.reverse();
        System.out.println(reversedString);

        return joinedStr.toString().equals(reversedString.toString());
    }

    public static void main(String[] args) {
        Q32_ValidPalindrome obj1 = new Q32_ValidPalindrome();
        String sampleString = "32apa32";
        System.out.println(obj1.isPalindrome(sampleString));
    }
}
