package com.leetcode.arrays.medium;

// Given a matrix of M x N elements (M rows, N columns), return all elements of t
// he matrix in diagonal order as shown in the below image.
//
//
//
// Example:
//
//
// Input:
// [
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
// ]
//
// Output:  [1,2,4,7,5,3,6,8,9]
//
// Explanation:
//
//
//
//
//
// Note:
//
// The total number of elements of the given matrix will not exceed 10,000.
// 👍 1043 👎 379
/*
 O(n*m) Runtime: 2 ms, faster than 92.05% of Java online submissions for Diagonal Traverse.
 O(n*m) Memory Usage: 41.5 MB, less than 30.23% of Java online submissions for Diagonal Traverse.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class DiagonalTraverse_498 {
  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix.length == 0) {
      return new int[] {};
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int[] result = new int[m * n];

    int row = 0;
    int col = 0;

    for (int i = 0; i < result.length; i++) {
      result[i] = matrix[row][col];

      if ((row + col) % 2 == 0) {
        if (col == n - 1) {
          row++;
        } else if (row == 0) {
          col++;
        } else {
          row--;
          col++;
        }
      } else {
        if (row == m - 1) {
          col++;
        } else if (col == 0) {
          row++;
        } else {
          row++;
          col--;
        }
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
