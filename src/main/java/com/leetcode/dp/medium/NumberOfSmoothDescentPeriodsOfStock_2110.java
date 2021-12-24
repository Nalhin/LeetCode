package com.leetcode.dp.medium;

// You are given an integer array prices representing the daily price history of
// a stock, where prices[i] is the stock price on the iᵗʰ day.
//
// A smooth descent period of a stock consists of one or more contiguous days
// such that the price on each day is lower than the price on the preceding day by
// exactly 1. The first day of the period is exempted from this rule.
//
// Return the number of smooth descent periods.
//
//
// Example 1:
//
//
// Input: prices = [3,2,1,4]
// Output: 7
// Explanation: There are 7 smooth descent periods:
// [3], [2], [1], [4], [3,2], [2,1], and [3,2,1]
// Note that a period with one day is a smooth descent period by the definition.
//
//
// Example 2:
//
//
// Input: prices = [8,6,7,7]
// Output: 4
// Explanation: There are 4 smooth descent periods: [8], [6], [7], and [7]
// Note that [8,6] is not a smooth descent period as 8 - 6 ≠ 1.
//
//
// Example 3:
//
//
// Input: prices = [1]
// Output: 1
// Explanation: There is 1 smooth descent period: [1]
//
//
//
// Constraints:
//
//
// 1 <= prices.length <= 10⁵
// 1 <= prices[i] <= 10⁵
//
// Related Topics Array Math Dynamic Programming 👍 190 👎 6

/*
 O(n) Runtime: 2 ms, faster than 97.10% of Java online submissions for Number of Smooth Descent Periods of a Stock.
 O(1) Memory Usage: 51.6 MB, less than 83.41% of Java online submissions for Number of Smooth Descent Periods of a Stock.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class NumberOfSmoothDescentPeriodsOfStock_2110 {
  public long getDescentPeriods(int[] prices) {
    int currCount = 1;
    long result = 1;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i - 1] == prices[i] + 1) {
        currCount++;
      } else {
        currCount = 1;
      }
      result += currCount;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
