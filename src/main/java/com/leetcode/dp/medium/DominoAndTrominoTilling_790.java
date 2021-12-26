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
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Domino and Tromino Tiling.
  O(1) Memory Usage: 36.1 MB, less than 27.42% of Java online submissions for Domino and Tromino Tiling.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class DominoAndTrominoTilling_790 {
  private static final int MOD = 1_000_000_007;

  public int numTilings(int n) {
    int full = 1;
    int fullPrev = 1;
    int partial = 0;

    for (int i = 2; i <= n; i++) {
      int newFull = (partial * 2 % MOD + (full + fullPrev) % MOD) % MOD;
      int newPartial = (fullPrev + partial) % MOD;

      fullPrev = full;
      full = newFull;
      partial = newPartial;
    }

    return full;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
