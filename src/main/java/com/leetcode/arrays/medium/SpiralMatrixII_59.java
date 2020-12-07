package com.leetcode.arrays.medium;

// Given a positive integer n, generate an n x n matrix filled with elements from
// 1 to n2 in spiral order.
//
//
// Example 1:
//
//
// Input: n = 3
// Output: [[1,2,3],[8,9,4],[7,6,5]]
//
//
// Example 2:
//
//
// Input: n = 1
// Output: [[1]]
//
//
//
// Constraints:
//
//
// 1 <= n <= 20
//
// Related Topics Array
// 👍 1372 👎 124

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n^2) Runtime: 105 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
 O(n^2) Memory Usage: 54.2 MB, less than 5.24% of Java online submissions for Spiral Matrix II.
*/
public class SpiralMatrixII_59 {
  private final int[][] DXDY = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int[][] generateMatrix(int n) {
    int target = n * n;
    int curr = 1;
    int[][] result = new int[n][n];
    result[0][0] = curr++;
    int x = 0;
    int y = 0;
    int increase = 0;

    while (curr <= target) {
      if (!isEdge(result, x + DXDY[increase][0], y + DXDY[increase][1])) {
        increase = (increase + 1) % 4;
      } else {
        x += DXDY[increase][0];
        y += DXDY[increase][1];
        result[x][y] = curr++;
      }
    }
    return result;
  }

  private boolean isEdge(int[][] matrix, int x, int y) {
    if (x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) {
      return false;
    }
    return matrix[x][y] == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
