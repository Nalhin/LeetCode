package com.leetcode.arrays.medium;

// You are given an n x n 2D matrix representing an image, rotate the image by 90
// degrees (clockwise).
//
// You have to rotate the image in-place, which means you have to modify the inp
// ut 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//
// Example 1:
//
//
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]
//
//
// Example 2:
//
//
// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
// Example 3:
//
//
// Input: matrix = [[1]]
// Output: [[1]]
//
//
// Example 4:
//
//
// Input: matrix = [[1,2],[3,4]]
// Output: [[3,1],[4,2]]
//
//
//
// Constraints:
//
//
// matrix.length == n
// matrix[i].length == n
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
//
// Related Topics Array
// 👍 4827 👎 337
/*
 O(n^2) Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
 O(1) Memory Usage: 39 MB, less than 48.90% of Java online submissions for Rotate Image.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class RotateImage_48 {
  public void rotate(int[][] matrix) {
    transpose(matrix);
    reverse(matrix);
  }

  private void transpose(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int tmp = matrix[j][i];
        matrix[j][i] = matrix[i][j];
        matrix[i][j] = tmp;
      }
    }
  }

  private void reverse(int[][] matrix) {
    int n = matrix.length;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][n - j - 1];
        matrix[i][n - j - 1] = temp;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
