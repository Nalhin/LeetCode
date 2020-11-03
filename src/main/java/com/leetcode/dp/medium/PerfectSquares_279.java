package com.leetcode.dp.medium;

// Given a positive integer n, find the least number of perfect square numbers (f
// or example, 1, 4, 9, 16, ...) which sum to n.
//
// Example 1:
//
//
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
//
// Example 2:
//
//
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9. Related Topics Math Dynamic Programming Breadth-first
// Search
// 👍 3550 👎 213

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.stream.IntStream;
/*
  O(n * sqrt(n)) Runtime: 35 ms, faster than 53.30% of Java online submissions for Perfect Squares.
  O(n) Memory Usage: 38 MB, less than 5.56% of Java online submissions for Perfect Squares.
 */
public class PerfectSquares_279 {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    int[] perfect = IntStream.range(1, (int) Math.sqrt(n) + 1).map(i -> i * i).toArray();

    Arrays.fill(dp, n + 1);
    dp[0] = 0;

    for (int i = 0; i <= n; i++) {
      for (int k : perfect) {
        int index = i - k;
        if (index < 0) {
          break;
        }
        dp[i] = Math.min(dp[index] + 1, dp[i]);
      }
    }
    return dp[n];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
