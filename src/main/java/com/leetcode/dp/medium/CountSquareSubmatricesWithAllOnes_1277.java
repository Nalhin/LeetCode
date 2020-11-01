package com.leetcode.dp.medium;

// Given a m * n matrix of ones and zeros, return how many square submatrices hav
// e all ones.
//
//
// Example 1:
//
//
// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation:
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.
//
//
// Example 2:
//
//
// Input: matrix =
// [
//  [1,0,1],
//  [1,1,0],
//  [1,1,0]
// ]
// Output: 7
// Explanation:
// There are 6 squares of side 1.
// There is 1 square of side 2.
// Total number of squares = 6 + 1 = 7.
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 300
// 1 <= arr[0].length <= 300
// 0 <= arr[i][j] <= 1
//
// Related Topics Array Dynamic Programming
// 👍 1351 👎 23

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n*m) Runtime: 5 ms, faster than 94.68% of Java online submissions for Count Square Submatrices with All Ones.
  O(n*m) Memory Usage: 51.4 MB, less than 5.21% of Java online submissions for Count Square Submatrices with All Ones.
*/
public class CountSquareSubmatricesWithAllOnes_1277 {
  public int countSquares(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row + 1][col + 1];

    int sum = 0;
    for (int i = 1; i <= row; i++) {
      for (int j = 1; j <= col; j++) {
        if (matrix[i - 1][j - 1] == 0) {
          continue;
        }
        int top = dp[i - 1][j];
        int topLeft = dp[i - 1][j - 1];
        int left = dp[i][j - 1];

        dp[i][j] = Math.min(Math.min(top, topLeft), left) + 1;
        sum += dp[i][j];
      }
    }

    return sum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
