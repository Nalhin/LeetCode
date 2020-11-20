package com.leetcode.arrays.easy;

// Given a square matrix mat, return the sum of the matrix diagonals.
//
// Only include the sum of all the elements on the primary diagonal and all the
// elements on the secondary diagonal that are not part of the primary diagonal.
//
//
// Example 1:
//
//
// Input: mat = [[1,2,3],
//               [4,5,6],
//               [7,8,9]]
// Output: 25
// Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
// Notice that element mat[1][1] = 5 is counted only once.
//
//
// Example 2:
//
//
// Input: mat = [[1,1,1,1],
//               [1,1,1,1],
//               [1,1,1,1],
//               [1,1,1,1]]
// Output: 8
//
//
// Example 3:
//
//
// Input: mat = [[5]]
// Output: 5
//
//
//
// Constraints:
//
//
// n == mat.length == mat[i].length
// 1 <= n <= 100
// 1 <= mat[i][j] <= 100
//
// Related Topics Array
// 👍 234 👎 6

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Matrix Diagonal Sum.
 O(1) Memory Usage: 38.9 MB, less than 84.44% of Java online submissions for Matrix Diagonal Sum.
*/
public class MatrixDiagonalSum_1572 {
  public int diagonalSum(int[][] mat) {
    int ans = 0;

    for (int i = 0; i < mat.length; i++) {
      ans += mat[i][i];
      if (mat.length - 1 - i != i) {
        ans += mat[i][mat.length - 1 - i];
      }
    }
    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
