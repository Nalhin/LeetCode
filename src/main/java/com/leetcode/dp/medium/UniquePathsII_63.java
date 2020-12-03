package com.leetcode.dp.medium;

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
// he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
// is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
// iagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths
// would there be?
//
// An obstacle and space is marked as 1 and 0 respectively in the grid.
//
//
// Example 1:
//
//
// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right
//
//
// Example 2:
//
//
// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1
//
//
//
// Constraints:
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] is 0 or 1.
//
// Related Topics Array Dynamic Programming
// 👍 2230 👎 267

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n * m)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
  O(n * m)  Memory Usage: 38.4 MB, less than 36.20% of Java online submissions for Unique Paths II.
*/
public class UniquePathsII_63 {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;

    if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
      return 0;
    }

    int[][] dp = new int[m + 1][n + 1];

    dp[1][1] = 1;

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (obstacleGrid[i - 1][j - 1] != 1) {
          dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }

    return dp[m][n];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
