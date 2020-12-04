package com.leetcode.dp.medium;

// In a country popular for train travel, you have planned some train travelling
// one year in advance. The days of the year that you will travel is given as an ar
// ray days. Each day is an integer from 1 to 365.
//
// Train tickets are sold in 3 different ways:
//
//
// a 1-day pass is sold for costs[0] dollars;
// a 7-day pass is sold for costs[1] dollars;
// a 30-day pass is sold for costs[2] dollars.
//
//
// The passes allow that many days of consecutive travel. For example, if we get
// a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and
// 8.
//
// Return the minimum number of dollars you need to travel every day in the give
// n list of days.
//
//
//
// Example 1:
//
//
// Input: days = [1,4,6,7,8,20], costs = [2,7,15]
// Output: 11
// Explanation:
// For example, here is one way to buy passes that lets you travel your travel pl
// an:
// On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
// On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4,
// ..., 9.
// On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
// In total you spent $11 and covered all the days of your travel.
//
//
//
// Example 2:
//
//
// Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
// Output: 17
// Explanation:
// For example, here is one way to buy passes that lets you travel your travel pl
// an:
// On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2,
// ..., 30.
// On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
// In total you spent $17 and covered all the days of your travel.
//
//
//
//
//
// Note:
//
//
// 1 <= days.length <= 365
// 1 <= days[i] <= 365
// days is in strictly increasing order.
// costs.length == 3
// 1 <= costs[i] <= 1000
//
// Related Topics Dynamic Programming
// 👍 2291 👎 44

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(n) Runtime: 1 ms, faster than 73.57% of Java online submissions for Minimum Cost For Tickets.
 O(n) Memory Usage: 36.7 MB, less than 74.14% of Java online submissions for Minimum Cost For Tickets.
*/
public class MinimumCostForTickets_983 {
  private final int OFFSET = 30;

  public int mincostTickets(int[] days, int[] costs) {
    int lastDay = days[days.length - 1];
    int[] dp = new int[OFFSET + lastDay + 1];
    int[] costDays = new int[] {1, 7, 30};

    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int i = 0; i <= OFFSET; i++) {
      dp[i] = 0;
    }

    int dayCount = 0;
    for (int i = OFFSET; i < dp.length; i++) {
      if (i == days[dayCount] + OFFSET) {
        for (int j = 0; j < costDays.length; j++) {
          int prev = i - costDays[j];
          dp[i] = Math.min(dp[i], dp[prev] + costs[j]);
        }
        dayCount++;
      } else {
        dp[i] = dp[i - 1];
      }
    }
    return dp[OFFSET + lastDay];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
