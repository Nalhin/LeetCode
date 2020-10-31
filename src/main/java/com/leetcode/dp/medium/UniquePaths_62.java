package com.leetcode.dp.medium;

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
// he diagram below).
//
// The robot can only move either down or right at any point in time. The robot
// is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
// iagram below).
//
// How many possible unique paths are there?
//
//
// Example 1:
//
//
// Input: m = 3, n = 7
// Output: 28
//
//
// Example 2:
//
//
// Input: m = 3, n = 2
// Output: 3
// Explanation:
// From the top-left corner, there are a total of 3 ways to reach the bottom-righ
// t corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down
//
//
// Example 3:
//
//
// Input: m = 7, n = 3
// Output: 28
//
//
// Example 4:
//
//
// Input: m = 3, n = 3
// Output: 6
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 100
// It's guaranteed that the answer will be less than or equal to 2 * 109.
//
// Related Topics Array Dynamic Programming
// 👍 4014 👎 226

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)

public class UniquePaths_62 {
  /*
   O(n * m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
   O(n * m) Memory Usage: 35.6 MB, less than 12.57% of Java online submissions for Unique Paths.
  */
  static class TwoDimensions {
    public int uniquePaths(int m, int n) {
      int[][] dp = new int[m][n];
      dp[0][0] = 1;

      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (i - 1 >= 0) {
            dp[i][j] += dp[i - 1][j];
          }
          if (j - 1 >= 0) {
            dp[i][j] += dp[i][j - 1];
          }
        }
      }
      return dp[m - 1][n - 1];
    }
  }

  /*
   O(n * m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
   O(m) Memory Usage: 35.6 MB, less than 12.57% of Java online submissions for Unique Paths.
  */
  static class OneDimension {
    public int uniquePaths(int m, int n) {
      int[] dp = new int[m];
      Arrays.fill(dp, 1);
      for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
          dp[j] += dp[j - 1];
        }
      }
      return dp[m - 1];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
