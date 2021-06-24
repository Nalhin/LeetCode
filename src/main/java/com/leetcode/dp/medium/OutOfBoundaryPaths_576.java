package com.leetcode.dp.medium;

// There is an m x n grid with a ball. The ball is initially at the position [sta
// rtRow, startColumn]. You are allowed to move the ball to one of the four adjacen
// t cells in the grid (possibly out of the grid crossing the grid boundary). You c
// an apply at most maxMove moves to the ball.
//
// Given the five integers m, n, maxMove, startRow, startColumn, return the numb
// er of paths to move the ball out of the grid boundary. Since the answer can be v
// ery large, return it modulo 109 + 7.
//
//
// Example 1:
//
//
// Input: m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
// Output: 6
//
//
// Example 2:
//
//
// Input: m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
// Output: 12
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 50
// 0 <= maxMove <= 50
// 0 <= startRow < m
// 0 <= startColumn < n
//
// Related Topics Dynamic Programming
// 👍 1040 👎 166

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class OutOfBoundaryPaths_576 {

  /*
    O(m * n * maxMove) Runtime: 3 ms, faster than 98.94% of Java online submissions for Out of Boundary Paths.
    O(m * n * maxMove) Memory Usage: 38.3 MB, less than 42.37% of Java online submissions for Out of Boundary Paths.
  */
  static class DpTopDown {

    private static final int MOD = 1_000_000_007;
    private static final int[][] AVAILABLE_MOVES = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
      int[][][] memo = new int[m][n][maxMove + 1];
      for (int[][] matrix : memo) {
        for (int[] row : matrix) {
          Arrays.fill(row, -1);
        }
      }

      return dfs(memo, m, n, startRow, startColumn, maxMove);
    }

    private int dfs(int[][][] memo, int rows, int cols, int row, int col, int movesLeft) {
      if (row < 0 || row >= rows || col < 0 || col >= cols) {
        return 1;
      }

      if (movesLeft <= 0) {
        return 0;
      }

      if (memo[row][col][movesLeft] != -1) {
        return memo[row][col][movesLeft];
      }

      int result = 0;
      for (int[] move : AVAILABLE_MOVES) {
        result =
            (result + dfs(memo, rows, cols, row + move[0], col + move[1], movesLeft - 1)) % MOD;
      }

      memo[row][col][movesLeft] = result;

      return result;
    }
  }
  /*
   O(m * n * maxMove) Runtime: 10 ms, faster than 38.14% of Java online submissions for Out of Boundary Paths.
   O(m * n) Memory Usage: 38.2 MB, less than 53.18% of Java online submissions for Out of Boundary Paths.
  */
  static class DpBottomUp {

    private static final int MOD = 1_000_000_007;
    private static final int[][] AVAILABLE_MOVES = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
      int[][] dp = new int[m][n];
      dp[startRow][startColumn] = 1;
      int result = 0;

      for (int moveCount = 0; moveCount < maxMove; moveCount++) {
        int[][] temp = new int[m][n];

        for (int row = 0; row < m; row++) {
          for (int col = 0; col < n; col++) {
            for (int[] availableMove : AVAILABLE_MOVES) {
              int newRow = row + availableMove[0];
              int newCol = col + availableMove[1];
              if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                result = (result + dp[row][col]) % MOD;
              } else {
                temp[newRow][newCol] = (temp[newRow][newCol] + dp[row][col]) % MOD;
              }
            }
          }
        }
        dp = temp;
      }

      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
