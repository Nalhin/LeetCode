package com.leetcode.easy;

// Say you have an array for which the ith element is the price of a given stock
// on day i.
//
// If you were only permitted to complete at most one transaction (i.e., buy one
// and sell one share of the stock), design an algorithm to find the maximum profi
// t.
//
// Note that you cannot sell a stock before you buy one.
//
// Example 1:
//
//
// Input: [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
// 6-1 = 5.
//              Not 7-1 = 6, as selling price needs to be larger than buying pric
// e.
//
//
// Example 2:
//
//
// Input: [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.
//
// Related Topics Array Dynamic Programming
// 👍 5931 👎 257

// leetcode submit region begin(Prohibit modification and deletion)

public class BestTimeToBuyAndSellStock_121 {
  public int maxProfit(int[] prices) {
    int best = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < prices.length; i++) {
      if (prices[i] < min) {
        min = prices[i];
      } else if (prices[i] - min > best) {
        best = prices[i] - min;
      }
    }
    return best;
  }
}

/*
    Success: Runtime:1 ms, faster than 99.29% of Java online submissions.
    Memory Usage:39.1 MB, less than 93.42% of Java online submissions
*/

// leetcode submit region end(Prohibit modification and deletion)
