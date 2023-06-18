// Date: 06 March 2023
// Q17: You are given an m x n integer grid accounts where accounts[i][j]
// is the amount of money the ith customer has in the jth bank. Return the wealth that the richest customer has.
// A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the
// customer that has the maximum wealth.

package Easy;
public class Q17_RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int sum=0, max=0;
        for (int i=0; i<accounts.length; i++){
            sum=0;
            for (int j=0; j<accounts[i].length; j++){
                sum = sum + accounts[i][j];
            }
            if (sum>max) max = sum;
        }
        return max;
    }
}

