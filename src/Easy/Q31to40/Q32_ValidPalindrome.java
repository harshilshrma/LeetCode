// Date: July 08, 2023
// Q31: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
// all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
// and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

package Easy.Q31to40;

public class Q32_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;

        return false;
    }

    public static void main(String[] args) {
        Q32_ValidPalindrome obj1 = new Q32_ValidPalindrome();
        String strs = "b";
        System.out.println(obj1.isPalindrome(strs));
    }
}
