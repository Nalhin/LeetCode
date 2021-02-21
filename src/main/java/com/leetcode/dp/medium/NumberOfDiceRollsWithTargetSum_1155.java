package com.leetcode.dp.medium;

// You have d dice, and each die has f faces numbered 1, 2, ..., f.
//
// Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to
// roll the dice so the sum of the face up numbers equals target.
//
//
// Example 1:
//
//
// Input: d = 1, f = 6, target = 3
// Output: 1
// Explanation:
// You throw one die with 6 faces.  There is only one way to get a sum of 3.
//
//
// Example 2:
//
//
// Input: d = 2, f = 6, target = 7
// Output: 6
// Explanation:
// You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
// 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
//
//
// Example 3:
//
//
// Input: d = 2, f = 5, target = 10
// Output: 1
// Explanation:
// You throw two dice, each with 5 faces.  There is only one way to get a sum of
// 10: 5+5.
//
//
// Example 4:
//
//
// Input: d = 1, f = 2, target = 3
// Output: 0
// Explanation:
// You throw one die with 2 faces.  There is no way to get a sum of 3.
//
//
// Example 5:
//
//
// Input: d = 30, f = 30, target = 500
// Output: 222616187
// Explanation:
// The answer must be returned modulo 10^9 + 7.
//
//
//
// Constraints:
//
//
// 1 <= d, f <= 30
// 1 <= target <= 1000
// Related Topics Dynamic Programming
// 👍 1147 👎 56

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(d*f) Runtime: 14 ms, faster than 71.28% of Java online submissions for Number of Dice Rolls With Target Sum.
 O(target * d) Memory Usage: 38.2 MB, less than 50.33% of Java online submissions for Number of Dice Rolls With Target Sum.
*/
public class NumberOfDiceRollsWithTargetSum_1155 {
  private static final int MOD = 1000000007;

  public int numRollsToTarget(int d, int f, int target) {
    int[][] dp = new int[target + 1][d + 1];
    for (int i = 0; i <= target; i++) {
      Arrays.fill(dp[i], -1);
    }

    return dfs(d, f, target, dp);
  }

  public int dfs(int d, int f, int target, int[][] dp) {
    if (target == 0 && d == 0) {
      return 1;
    }
    if (target < 0 || d < 0) {
      return 0;
    }

    if (dp[target][d] != -1) {
      return dp[target][d];
    }

    int curr = 0;

    for (int i = 1; i <= f; i++) {
      curr = (curr + dfs(d - 1, f, target - i, dp)) % MOD;
    }

    dp[target][d] = curr;

    return curr;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
