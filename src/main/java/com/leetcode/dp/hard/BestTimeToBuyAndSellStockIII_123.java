package com.leetcode.dp.hard;

// You are given an array prices where prices[i] is the price of a given stock
// on the iᵗʰ day.
//
// Find the maximum profit you can achieve. You may complete at most two
// transactions.
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you
// must sell the stock before you buy again).
//
//
// Example 1:
//
//
// Input: prices = [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit =
// 3-0 = 3.
// Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
//
//
// Example 2:
//
//
// Input: prices = [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
// 5-1 = 4.
// Note that you cannot buy on day 1, buy on day 2 and sell them later, as you
// are engaging multiple transactions at the same time. You must sell before buying
// again.
//
//
// Example 3:
//
//
// Input: prices = [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
//
// Example 4:
//
//
// Input: prices = [1]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 10⁵
// 0 <= prices[i] <= 10⁵
//
// Related Topics Array Dynamic Programming 👍 4708 👎 102
/*
  O(n) Runtime: 4 ms, faster than 77.03% of Java online submissions for Best Time to Buy and Sell Stock III.
  O(1) Memory Usage: 98.2 MB, less than 37.00% of Java online submissions for Best Time to Buy and Sell Stock III.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class BestTimeToBuyAndSellStockIII_123 {
  public int maxProfit(int[] prices) {
    int zeroHold = -prices[0];
    int oneHold = -prices[0];
    int oneEmpty = 0;
    int twoEmpty = 0;

    for (int i = 1; i < prices.length; i++) {
      int prevOneEmpty = oneEmpty;
      int prevTwoEmpty = twoEmpty;
      int prevZeroHold = zeroHold;
      int prevOneHold = oneHold;

      oneEmpty = Math.max(prevOneEmpty, prevZeroHold + prices[i]);
      twoEmpty = Math.max(prevTwoEmpty, prevOneHold + prices[i]);
      zeroHold = Math.max(prevZeroHold, -prices[i]);
      oneHold = Math.max(prevOneHold, prevOneEmpty - prices[i]);
    }

    return Math.max(oneEmpty, twoEmpty);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
