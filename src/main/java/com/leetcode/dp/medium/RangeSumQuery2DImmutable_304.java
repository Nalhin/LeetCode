package com.leetcode.dp.medium;

// Given a 2D matrix matrix, handle multiple queries of the following type:
//
//
// Calculate the sum of the elements of matrix inside the rectangle defined by i
// ts upper left corner (row1, col1) and lower right corner (row2, col2).
//
//
// Implement the NumMatrix class:
//
//
// NumMatrix(int[][] matrix) Initializes the object with the integer matrix matr
// ix.
// int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the
// elements of matrix inside the rectangle defined by its upper left corner (row1,
// col1) and lower right corner (row2, col2).
//
//
//
// Example 1:
//
//
// Input
// ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
// [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0,
// 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
// Output
// [null, 8, 11, 12]
//
// Explanation
// NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2,
// 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
// numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
// numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
//
// numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// -105 <= matrix[i][j] <= 105
// 0 <= row1 <= row2 < m
// 0 <= col1 <= col2 < n
// At most 104 calls will be made to sumRegion.
//
// Related Topics Dynamic Programming
// 👍 1667 👎 211
/*
 O(1) (amortized) Runtime: 11 ms, faster than 64.76% of Java online submissions for Range Sum Query 2D - Immutable.
 O(nm) Memory Usage: 44.7 MB, less than 53.46% of Java online submissions for Range Sum Query 2D - Immutable.

 */
// leetcode submit region begin(Prohibit modification and deletion)

public class RangeSumQuery2DImmutable_304 {
  static class NumMatrix {

    private final int[][] prefixSums;

    public NumMatrix(int[][] matrix) {
      prefixSums = generatePrefixSums(matrix);
    }

    private int[][] generatePrefixSums(int[][] matrix) {
      int rows = matrix.length;
      int cols = matrix[0].length;
      int[][] sums = new int[rows + 1][cols + 1];

      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          sums[i + 1][j + 1] = matrix[i][j] + sums[i][j + 1] + sums[i + 1][j] - sums[i][j];
        }
      }

      return sums;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      return prefixSums[row2 + 1][col2 + 1]
          + prefixSums[row1][col1]
          - prefixSums[row2 + 1][col1]
          - prefixSums[row1][col2 + 1];
    }
  }
}
/*
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj = new
 * NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// leetcode submit region end(Prohibit modification and deletion)
