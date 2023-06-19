// Date: 24 February 2023
// Q1: Given an integer x, return true if x is a palindrome, and false otherwise.

package Easy.Q01to10;
public class Q1_PalindromeNumber {
    public boolean isPalindrome(int x) {
        int original, reversed=0, rem;
        original = x;
        if (x < 0){
            return false;  //For negative numbers because palindrome of -121 is 121- (which is a string)
        }
        while (x != 0) {   //Reversing the given number
            rem = x % 10;
            reversed = reversed*10 + rem;
            x /= 10;
        }
        if (reversed == original){
            return true;
        }
        else{
            return false;
        }
    }
}
