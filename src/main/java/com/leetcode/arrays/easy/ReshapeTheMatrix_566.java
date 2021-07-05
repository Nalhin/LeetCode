package com.leetcode.arrays.easy;

// In MATLAB, there is a handy function called reshape which can reshape an m x n
// matrix into a new one with a different size r x c keeping its original data.
//
// You are given an m x n matrix mat and two integers r and c representing the r
// ow number and column number of the wanted reshaped matrix.
//
// The reshaped matrix should be filled with all the elements of the original ma
// trix in the same row-traversing order as they were.
//
// If the reshape operation with given parameters is possible and legal, output
// the new reshaped matrix; Otherwise, output the original matrix.
//
//
// Example 1:
//
//
// Input: mat = [[1,2],[3,4]], r = 1, c = 4
// Output: [[1,2,3,4]]
//
//
// Example 2:
//
//
// Input: mat = [[1,2],[3,4]], r = 2, c = 4
// Output: [[1,2],[3,4]]
//
//
//
// Constraints:
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 100
// -1000 <= mat[i][j] <= 1000
// 1 <= r, c <= 300
//
// Related Topics Array Matrix Simulation
// 👍 1150 👎 129
/*
 O(n * m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reshape the Matrix.
 O(n * m) Memory Usage: 39.8 MB, less than 68.66% of Java online submissions for Reshape the Matrix.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class ReshapeTheMatrix_566 {
  public int[][] matrixReshape(int[][] mat, int r, int c) {
    int currRows = mat.length;
    int currCols = mat[0].length;

    if (c * r != currRows * currCols) {
      return mat;
    }

    int[][] result = new int[r][c];

    for (int i = 0; i < currRows; i++) {
      for (int j = 0; j < currCols; j++) {
        int cellsVisited = i * currCols + j;
        result[cellsVisited / c][cellsVisited % c] = mat[i][j];
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
