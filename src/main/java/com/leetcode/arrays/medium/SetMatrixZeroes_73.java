package com.leetcode.arrays.medium;

// Given an m x n integer matrix matrix, if an element is 0, set its entire row a
// nd column to 0's, and return the matrix.
//
// You must do it in place.
//
//
// Example 1:
//
//
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]
//
//
// Example 2:
//
//
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
//
//
//
// Follow up:
//
//
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
//
// Related Topics Array Hash Table Matrix
// 👍 4144 👎 397

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// leetcode submit region begin(Prohibit modification and deletion)
public class SetMatrixZeroes_73 {
  /*
   O(n * m) Runtime: 3 ms, faster than 13.35% of Java online submissions for Set Matrix Zeroes.
   O(n + m) Memory Usage: 51.7 MB, less than 5.59% of Java online submissions for Set Matrix Zeroes.
  */
  static class LinearMemory {
    public void setZeroes(int[][] matrix) {
      Set<Integer> rows = new HashSet<>();
      Set<Integer> cols = new HashSet<>();

      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j] == 0) {
            rows.add(i);
            cols.add(j);
          }
        }
      }

      for (int row : rows) {
        Arrays.fill(matrix[row], 0);
      }

      for (int col : cols) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][col] = 0;
        }
      }
    }
  }

  /*
   O(n * m) Runtime: 3 ms, faster than 13.35% of Java online submissions for Set Matrix Zeroes.
   O(1) Memory Usage: 50.9 MB, less than 5.59% of Java online submissions for Set Matrix Zeroes.
  */
  static class ConstMemory {
    public void setZeroes(int[][] matrix) {

      boolean fillFirstRow = false;
      boolean fillFirstCol = false;

      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[i].length; j++) {
          if (matrix[i][j] == 0) {
            matrix[0][j] = 0;
            matrix[i][0] = 0;

            if (i == 0) {
              fillFirstRow = true;
            }

            if (j == 0) {
              fillFirstCol = true;
            }
          }
        }
      }

      for (int i = 1; i < matrix[0].length; i++) {
        if (matrix[0][i] == 0) {
          for (int j = 1; j < matrix.length; j++) {
            matrix[j][i] = 0;
          }
        }
      }

      for (int i = 1; i < matrix.length; i++) {
        if (matrix[i][0] == 0) {
          Arrays.fill(matrix[i], 0);
        }
      }

      if (fillFirstRow) {
        Arrays.fill(matrix[0], 0);
      }

      if (fillFirstCol) {
        for (int i = 0; i < matrix.length; i++) {
          matrix[i][0] = 0;
        }
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
