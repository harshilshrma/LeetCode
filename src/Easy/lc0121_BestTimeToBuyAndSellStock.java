// Date: 17 December 2023
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
// the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

package Easy;

public class lc0121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // left = buy, right = sell
        int l = 0;
        int r = 1;
        int maxP = 0;

        while (r < prices.length){
            // profitable?
            if (prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                maxP = Math.max(maxP, profit);
            } else {
                // Because we found a really low price if prices[l] > prices[r], so we shift l to new lowest price = r
                l = r;
            }
            // Right pointer will be updated regardless of the conditions
            r += 1;
        }
        return maxP;
    }

    public static void main(String[] args) {
        lc0121_BestTimeToBuyAndSellStock obj = new lc0121_BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }
}
