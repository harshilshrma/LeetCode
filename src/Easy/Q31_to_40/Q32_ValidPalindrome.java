// Date: July 08, 2023
// Q31: A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
// all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters
// and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

package Easy.Q31_to_40;

// My Approach
public class Q32_ValidPalindrome {
    public boolean isPalindrome(String str) {
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
        String originalStr = joinedStr.toString();
        String reversedStr = joinedStr.reverse().toString();
//        System.out.println(originalStr);
//        System.out.println(reversedStr);
        return originalStr.equals(reversedStr);
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Two Pointer Approach

    // Didn't use this class because in-built methods of Character Class already exist
    public boolean isAlphaNumeric(Character c) {
        return ( ((int)'A' <= (int)c && (int)c <= (int)'Z') ||
                 ((int)'a' <= (int)c && (int)c <= (int)'z') ||
                 ((int)'0' <= (int)c && (int)c <= (int)'9')
        );
    }

    public boolean isPalindrome_TwoPointerMethod(String str) {
        int l = 0, r = str.length()-1;

        while (l < r) {
            Character start = str.charAt(l);
            Character end = str.charAt(r);
            if (!Character.isLetterOrDigit(start)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                r--;
                continue;
            }
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // Main function for testing
    public static void main(String[] args) {
        Q32_ValidPalindrome obj1 = new Q32_ValidPalindrome();
        String sampleString = "A man, a plan, a canal: Panama";
        System.out.println(obj1.isPalindrome(sampleString));
        System.out.println(obj1.isPalindrome_TwoPointerMethod(sampleString));
    }
}