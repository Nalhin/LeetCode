package com.leetcode.dp.medium;

// Your are given an array of integers prices, for which the i-th element is the
// price of a given stock on day i; and a non-negative integer fee representing a t
// ransaction fee.
// You may complete as many transactions as you like, but you need to pay the tr
// ansaction fee for each transaction. You may not buy more than 1 share of a stock
// at a time (ie. you must sell the stock share before you buy again.)
// Return the maximum profit you can make.
//
// Example 1:
//
// Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// Buying at prices[0] = 1 Selling at prices[3] = 8 Buying at prices[4] = 4 Sell
// ing at prices[5] = 9 The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//
//
//
// Note:
// 0 < prices.length <= 50000.
// 0 < prices[i] < 50000.
// 0 <= fee < 50000.
// Related Topics Array Dynamic Programming Greedy
// 👍 1849 👎 55

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 3 ms, faster than 92.44% of Java online submissions for Best Time to Buy and Sell Stock with Transaction Fee.
  O(1) Memory Usage: 48.5 MB, less than 5.14% of Java online submissions for Best Time to Buy and Sell Stock with Transaction Fee
*/
public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
  public int maxProfit(int[] prices, int fee) {
    int withoutStock = 0;
    int withStock = -prices[0] - fee;

    for (int i = 1; i < prices.length; i++) {
      withoutStock = Math.max(withStock + prices[i], withoutStock);
      withStock = Math.max(withoutStock - fee - prices[i], withStock);
    }

    return withoutStock;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
