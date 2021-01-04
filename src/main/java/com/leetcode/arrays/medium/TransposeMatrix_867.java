package com.leetcode.arrays.medium;

// Given a matrix A, return the transpose of A.
//
// The transpose of a matrix is the matrix flipped over it's main diagonal, swit
// ching the row and column indices of the matrix.
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[1,4,7],[2,5,8],[3,6,9]]
//
//
//
// Example 2:
//
//
// Input: [[1,2,3],[4,5,6]]
// Output: [[1,4],[2,5],[3,6]]
//
//
//
//
// Note:
//
//
// 1 <= A.length <= 1000
// 1 <= A[0].length <= 1000
//
//
// Related Topics Array
// 👍 552 👎 319

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n*m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Transpose Matrix.
 O(n*m) Memory Usage: 40.1 MB, less than 27.40% of Java online submissions for Transpose Matrix.
*/
public class TransposeMatrix_867 {
  public int[][] transpose(int[][] A) {
    int m = A.length;
    int n = A[0].length;

    int[][] result = new int[n][m];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result[j][i] = A[i][j];
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
