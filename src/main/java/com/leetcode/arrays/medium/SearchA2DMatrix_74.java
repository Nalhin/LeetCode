package com.leetcode.arrays.medium;

// Write an efficient algorithm that searches for a value in an m x n matrix. Thi
// s matrix has the following properties:
//
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previou
// s row.
//
//
//
// Example 1:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
// Output: true
//
//
// Example 2:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
// Output: false
//
//
// Example 3:
//
//
// Input: matrix = [], target = 0
// Output: false
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 0 <= m, n <= 100
// -104 <= matrix[i][j], target <= 104
//
// Related Topics Array Binary Search
// 👍 2322 👎 170

// leetcode submit region begin(Prohibit modification and deletion)

public class SearchA2DMatrix_74 {

  static class TwoSearches {
    public boolean searchMatrix(int[][] matrix, int target) {
      int top = 0;
      int bottom = matrix.length - 1;
      if (bottom < 0 || matrix[bottom].length <= 0) {
        return false;
      }
      int found = -1;

      while (top <= bottom) {
        int mid = (top + bottom) >> 1;
        int first = matrix[mid][0];
        int last = matrix[mid][matrix[mid].length - 1];
        if (target <= last && target >= first) {
          found = mid;
          break;
        } else if (target > last) {
          top = mid + 1;
        } else {
          bottom = mid - 1;
        }
      }
      if (found == -1) {
        return false;
      }

      int left = 0;
      int right = matrix[found].length - 1;
      while (left <= right) {
        int mid = (left + right) >>> 1;
        int curr = matrix[found][mid];

        if (curr == target) {
          return true;
        } else if (curr < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }

      return false;
    }
  }
  /*
   O(log(mn))  Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
   O(1)  Memory Usage: 38.3 MB, less than 17.39% of Java online submissions for Search a 2D Matrix.
  */

  static class SingleSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
      int n = matrix.length;
      if (n == 0) {
        return false;
      }

      int m = matrix[0].length;
      int left = 0;
      int right = m * n - 1;
      while (left <= right) {
        int mid = (left + right) >>> 1;
        int curr = matrix[mid / m][mid % m];
        if (curr == target) {
          return true;
        } else if (curr > target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }

      return false;
    }
  }
  /*
   O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
   O(1)  Memory Usage: 38.2 MB, less than 17.39% of Java online submissions for Search a 2D Matrix.
  */
}

// leetcode submit region end(Prohibit modification and deletion)
