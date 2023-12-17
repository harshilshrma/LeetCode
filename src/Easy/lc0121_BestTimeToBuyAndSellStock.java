// Date: 17 December 2023
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
// the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

package Easy;

public class lc0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {


    }

    public static void main(String[] args) {
        lc0121_BestTimeToBuyAndSellStock obj = new lc0121_BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }
}
