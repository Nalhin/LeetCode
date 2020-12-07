package com.leetcode.dp.medium;

// Say you have an array for which the ith element is the price of a given stock
// on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many tran
// sactions as you like (ie, buy one and sell one share of the stock multiple times
// ) with the following restrictions:
//
//
// You may not engage in multiple transactions at the same time (ie, you must se
// ll the stock before you buy again).
// After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1
// day)
//
//
// Example:
//
//
// Input: [1,2,3,0,2]
// Output: 3
// Explanation: transactions = [buy, sell, cooldown, buy, sell]
// Related Topics Dynamic Programming
// 👍 3181 👎 98

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 50.55% of Java online submissions for Best Time to Buy and Sell Stock with Cooldown.
 O(n) (can be improved to O(1)) Memory Usage: 36.5 MB, less than 99.37% of Java online submissions for Best Time to Buy and Sell Stock with Cool
*/
public class BestTimeToBuyAndSellStockWithCooldown_309 {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int[][] dp = new int[2][prices.length + 1];
    dp[1][0] = Integer.MIN_VALUE;
    dp[0][0] = 0;

    for (int i = 1; i <= prices.length; i++) {
      dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i - 1]);
      dp[0][i] = Math.max(dp[0][i - 1], i - 2 >= 0 ? dp[1][i - 2] + prices[i - 2] : 0);
    }
    return Math.max(dp[0][prices.length], dp[1][prices.length - 1] + prices[prices.length - 1]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
