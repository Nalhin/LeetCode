package com.leetcode.binarysearch.medium;

// Write an efficient algorithm that searches for a target value in an m x n inte
// ger matrix. The matrix has the following properties:
//
//
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
//
//
//
// Example 1:
//
//
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
// 8,21,23,26,30]], target = 5
// Output: true
//
//
// Example 2:
//
//
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[1
// 8,21,23,26,30]], target = 20
// Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -109 <= matix[i][j] <= 109
// All the integers in each row are sorted in ascending order.
// All the integers in each column are sorted in ascending order.
// -109 <= target <= 109
//
// Related Topics Binary Search Divide and Conquer
// 👍 4354 👎 86
/*
 O(n+m) Runtime: 4 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
 O(1) Memory Usage: 44.6 MB, less than 59.75% of Java online submissions for Search a 2D Matrix II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class SearchA2DMatrixII_240 {
  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length - 1;
    int cols = matrix[0].length - 1;

    int row = rows;
    int col = 0;

    while (row > 0 && col <= cols) {

      if (matrix[row][col] == target) {
        return true;
      }

      if (matrix[row][col] < target) {
        col++;
      } else {
        row--;
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
