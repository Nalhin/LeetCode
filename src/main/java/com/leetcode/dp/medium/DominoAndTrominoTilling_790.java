package com.leetcode.dp.medium;

// You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You
// may rotate these shapes.
//
// Given an integer n, return the number of ways to tile an 2 x n board. Since
// the answer may be very large, return it modulo 10⁹ + 7.
//
// In a tiling, every square must be covered by a tile. Two tilings are
// different if and only if there are two 4-directionally adjacent cells on the board such
// that exactly one of the tilings has both squares occupied by a tile.
//
//
// Example 1:
//
//
// Input: n = 3
// Output: 5
// Explanation: The five different ways are show above.
//
//
// Example 2:
//
//
// Input: n = 1
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= n <= 1000
//
// Related Topics Dynamic Programming 👍 1269 👎 528
/*
  O(n) Runtime: 3 ms, faster than 15.17% of Java online submissions for Domino and Tromino Tiling.
  O(1) Memory Usage: 36.1 MB, less than 27.42% of Java online submissions for Domino and Tromino Tiling.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class DominoAndTrominoTilling_790 {
  private static final int MOD = 1_000_000_007;

  public int numTilings(int n) {
    int[][] dp = new int[2][2];

    dp[1][0] = 1;
    dp[0][0] = 1;

    for (int i = 2; i <= n; i++) {

      int[][] newDp = new int[2][2];
      newDp[0][0] = dp[1][0];
      newDp[0][1] = dp[1][1];

      newDp[1][0] = (dp[1][1] * 2 % MOD + (dp[1][0] + dp[0][0]) % MOD) % MOD;
      newDp[1][1] = (dp[0][0] + dp[1][1]) % MOD;
      dp = newDp;
    }

    return dp[1][0];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
