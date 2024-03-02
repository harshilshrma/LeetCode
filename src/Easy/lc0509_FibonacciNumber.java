// Date: 2 March 2024
// The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each
// number is the sum of the two preceding ones, starting from 0 and 1. That is,
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
//Given n, calculate F(n).

package Easy;

public class lc0509_FibonacciNumber {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        lc0509_FibonacciNumber obj = new lc0509_FibonacciNumber();
        int n = 5;
        System.out.println(obj.fib(n));
    }
}
