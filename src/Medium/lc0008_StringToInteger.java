// 03-06-2024 - 01:59 pm
// Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//
//The algorithm for myAtoi(string s) is as follows:
//
//Whitespace: Ignore any leading whitespace (" ").
//Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
//Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//Return the integer as the final result.

package Medium;

public class lc0008_StringToInteger {
    // Functions
    public int myAtoi(String s) {
        int ans  = 0, ptr = 0, len = s.length();
        boolean negative = false;

        while (ptr < len && s.charAt(ptr) == ' ') {
            ptr++;
        }

        if (ptr < len && (s.charAt(ptr) == '-' || s.charAt(ptr) == '+')) {
            negative = s.charAt(ptr) == '-';
            ptr++;
        }

        while (ptr < len && Character.isDigit(s.charAt(ptr))) {
            int num = s.charAt(ptr) - '0';

            if (ans > (Integer.MAX_VALUE - num) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + num;
            ptr++;
        }

        return negative ? -ans : ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0008_StringToInteger obj = new lc0008_StringToInteger();
        System.out.println(obj.myAtoi("42"));
        System.out.println(obj.myAtoi("   -042"));
        System.out.println(obj.myAtoi("1337c0d3"));
        System.out.println(obj.myAtoi("0-1"));
        System.out.println(obj.myAtoi("words and 987"));
        System.out.println(obj.myAtoi("-91283472332"));
        System.out.println(obj.myAtoi("+1"));
    }
}



