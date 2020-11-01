package com.leetcode.dp.medium;

// Given a square array of integers A, we want the minimum sum of a falling path
// through A.
//
// A falling path starts at any element in the first row, and chooses one elemen
// t from each row. The next row's choice must be in a column that is different fro
// m the previous row's column by at most one.
//
//
//
// Example 1:
//
//
// Input: [[1,2,3],[4,5,6],[7,8,9]]
// Output: 12
// Explanation:
// The possible falling paths are:
//
//
//
// [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
// [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
// [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
//
//
// The falling path with the smallest sum is [1,4,7], so the answer is 12.
//
//
// Constraints:
//
//
// 1 <= A.length == A[0].length <= 100
// -100 <= A[i][j] <= 100
//
// Related Topics Dynamic Programming
// 👍 911 👎 70

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/*
 O(n^2) Runtime: 5 ms, faster than 22.08% of Java online submissions for Minimum Falling Path Sum.
 O(n^2) Memory Usage: 39.6 MB, less than 11.18% of Java online submissions for Minimum Falling Path Sum.
*/
public class MinimumFallingPathSum_931 {
  public int minFallingPathSum(int[][] A) {
    int n = A.length;

    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      dp[0][i] = A[0][i];
    }

    for (int i = 1; i < n; i++) {
      int[] prevRow = dp[i - 1];
      for (int j = 0; j < n; j++) {
        dp[i][j] = prevRow[j] + A[i][j];
        if (j + 1 < n) {
          dp[i][j] = Math.min(dp[i][j], prevRow[j + 1] + A[i][j]);
        }
        if (j - 1 >= 0) {
          dp[i][j] = Math.min(dp[i][j], prevRow[j - 1] + A[i][j]);
        }
      }
    }
    return Arrays.stream(dp[n - 1]).min().getAsInt();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
