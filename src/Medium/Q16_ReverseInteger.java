// Date: 06 March 2023
// Q16: Given a signed 32-bit integer x, return x with its digits reversed.
// If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

package Medium;
public class Q16_ReverseInteger {
    public int reverse(int x) {
        int temp;
        long reverse = 0;

        while(x!=0){
            temp = x % 10;
            reverse = reverse * 10 + temp;
            x = x/10;
        }
        if(reverse >= Integer.MIN_VALUE && reverse <= Integer.MAX_VALUE)
            return (int)reverse;
        else
            return 0;
    }
}


