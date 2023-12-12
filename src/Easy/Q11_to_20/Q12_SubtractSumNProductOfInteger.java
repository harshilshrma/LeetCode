// Date: 03 March 2023
// Q12: Given an integer number n, return the difference between the product of its digits and the sum of its digits.

package Easy.Q11_to_20;
public class Q12_SubtractSumNProductOfInteger {
    public int subtractProductAndSum(int n) {
        int rem, sum=0, pro=1;
        while (n >0){
            rem = n % 10;
            sum = sum + rem;
            pro = pro * rem;
            n = n/10;
        }
        return pro-sum;
    }
}

