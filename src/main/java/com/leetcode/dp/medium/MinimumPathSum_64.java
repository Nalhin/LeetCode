package com.leetcode.dp.medium;

// Given a m x n grid filled with non-negative numbers, find a path from top left
// to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
//
// Input:
// [
//   [1,3,1],
//  [1,5,1],
//  [4,2,1]
// ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
// Related Topics Array Dynamic Programming
// 👍 3734 👎 70

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n * m) Runtime: 2 ms, faster than 83.48% of Java online submissions for Minimum Path Sum.
 O(1)  Memory Usage: 41.8 MB, less than 6.65% of Java online submissions for Minimum Path Sum.
*/
public class MinimumPathSum_64 {
  public int minPathSum(int[][] grid) {
    int x = grid.length;
    int y = grid[0].length;

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (i - 1 >= 0 && j - 1 >= 0) {
          grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        } else if (i - 1 >= 0) {
          grid[i][j] += grid[i - 1][j];
        } else if (j - 1 >= 0) {
          grid[i][j] += grid[i][j - 1];
        }
      }
    }
    return grid[x - 1][y - 1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
