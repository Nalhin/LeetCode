package com.leetcode.dp.medium;

// Given an m x n binary matrix filled with 0's and 1's, find the largest square
// containing only 1's and return its area.
//
//
// Example 1:
//
//
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1",
// "1"],["1","0","0","1","0"]]
// Output: 4
//
//
// Example 2:
//
//
// Input: matrix = [["0","1"],["1","0"]]
// Output: 1
//
//
// Example 3:
//
//
// Input: matrix = [["0"]]
// Output: 0
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is '0' or '1'.
//
// Related Topics Dynamic Programming
// 👍 3997 👎 97
/*
 O(n*m) Runtime: 4 ms, faster than 87.10% of Java online submissions for Maximal Square.
 O(n*m) Memory Usage: 42.8 MB, less than 19.30% of Java online submissions for Maximal Square.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MaximalSquare_221 {
  public int maximalSquare(char[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] dp = new int[n + 1][m + 1];
    int max = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
          max = Math.max(max, dp[i][j] * dp[i][j]);
        }
      }
    }
    return max;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
