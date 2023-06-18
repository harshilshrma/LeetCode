// Date: 06 March 2023
// Q16: Given a signed 32-bit integer x, return x with its digits reversed.
// If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

package Medium;
public class Q16_ReverseInteger {
    public int reverse(int x) {
        long reverse=0, rem, original, a, max=2147483647, min=-2147483648;
        while (x!=0){
            rem = x%10;
            reverse = reverse*10 + rem;
            x/=10;
        }
        if(reverse > max || reverse < min){
            reverse =0;
        }
        if (x<0) return (int)-reverse;
        else return (int)reverse;
    }
}


