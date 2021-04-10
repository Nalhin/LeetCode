package com.leetcode.dp.hard;

// Given an m x n integers matrix, return the length of the longest increasing pa
// th in matrix.
//
// From each cell, you can either move in four directions: left, right, up, or d
// own. You may not move diagonally or move outside the boundary (i.e., wrap-around
// is not allowed).
//
//
// Example 1:
//
//
// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].
//
//
// Example 2:
//
//
// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is
// not allowed.
//
//
// Example 3:
//
//
// Input: matrix = [[1]]
// Output: 1
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// 0 <= matrix[i][j] <= 231 - 1
//
// Related Topics Depth-first Search Topological Sort Memoization
// 👍 2961 👎 54

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nm) Runtime: 8 ms, faster than 70.79% of Java online submissions for Longest Increasing Path in a Matrix.
 O(nm) Memory Usage: 39.2 MB, less than 68.98% of Java online submissions for Longest Increasing Path in a Matrix.
*/
import java.util.Arrays;

public class LongestIncreasingPathInAMatrix_329 {
  private final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int longestIncreasingPath(int[][] matrix) {
    int[][] dp = new int[matrix.length][matrix[0].length];
    for (int[] row : dp) {
      Arrays.fill(row, -1);
    }

    int result = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        result = Math.max(dfs(matrix, dp, i, j, -1), result);
      }
    }

    return result;
  }

  private int dfs(int[][] matrix, int[][] dp, int row, int col, int prevVal) {
    if (row >= matrix.length
        || row < 0
        || col < 0
        || col >= matrix[0].length
        || matrix[row][col] <= prevVal) {
      return 0;
    }

    if (dp[row][col] != -1) {
      return dp[row][col];
    }

    int maxPath = 0;
    for (int[] dir : DIRECTIONS) {
      maxPath =
          Math.max(dfs(matrix, dp, row + dir[0], col + dir[1], matrix[row][col]) + 1, maxPath);
    }
    dp[row][col] = maxPath;

    return maxPath;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
