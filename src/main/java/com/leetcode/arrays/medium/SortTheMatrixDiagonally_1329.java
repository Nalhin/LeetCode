package com.leetcode.arrays.medium;

// A matrix diagonal is a diagonal line of cells starting from some cell in eithe
// r the topmost row or leftmost column and going in the bottom-right direction unt
// il reaching the matrix's end. For example, the matrix diagonal starting from mat
// [2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and ma
// t[4][2].
//
// Given an m x n matrix mat of integers, sort each matrix diagonal in ascending
// order and return the resulting matrix.
//
//
// Example 1:
//
//
// Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
// Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
//
//
//
// Constraints:
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 100
// 1 <= mat[i][j] <= 100
//
// Related Topics Array Sort
// 👍 649 👎 134

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n*m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort the Matrix Diagonally.
 O(1) Memory Usage: 39.9 MB, less than 54.72% of Java online submissions for Sort the Matrix Diagonally.
*/
public class SortTheMatrixDiagonally_1329 {
  public int[][] diagonalSort(int[][] mat) {

    for (int i = mat.length - 1; i >= 0; i--) {
      sortDiagonal(mat, i, 0);
    }

    for (int i = 1; i < mat[0].length; i++) {
      sortDiagonal(mat, 0, i);
    }

    return mat;
  }

  private void sortDiagonal(int[][] mat, int row, int col) {
    int[] counter = new int[101];

    int currRow = row;
    int currCol = col;

    while (currRow < mat.length && currCol < mat[0].length) {
      counter[mat[currRow][currCol]]++;
      currRow++;
      currCol++;
    }

    int curr = 0;
    while (row < mat.length && col < mat[0].length) {
      while (counter[curr] <= 0) {
        curr++;
      }
      mat[row][col] = curr;
      counter[curr]--;
      row++;
      col++;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
