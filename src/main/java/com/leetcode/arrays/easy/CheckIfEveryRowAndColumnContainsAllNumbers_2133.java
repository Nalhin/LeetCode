package com.leetcode.arrays.easy;

// An n x n matrix is valid if every row and every column contains all the
// integers from 1 to n (inclusive).
//
// Given an n x n integer matrix matrix, return true if the matrix is valid.
// Otherwise, return false.
//
//
// Example 1:
//
//
// Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
// Output: true
// Explanation: In this case, n = 3, and every row and column contains the
// numbers 1, 2, and 3.
// Hence, we return true.
//
//
// Example 2:
//
//
// Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
// Output: false
// Explanation: In this case, n = 3, but the first row and the first column do
// not contain the numbers 2 or 3.
// Hence, we return false.
//
//
//
// Constraints:
//
//
// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// 1 <= matrix[i][j] <= n
//
// Related Topics Array Hash Table Matrix 👍 220 👎 13
/*
 O(n*m) Runtime: 70 ms, faster than 26.98% of Java online submissions for Check if Every Row and Column Contains All Numbers.
 O(n+m)Memory Usage: 96.1 MB, less than 44.56% of Java online submissions for Check if Every Row and Column Contains All Numbers.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

public class CheckIfEveryRowAndColumnContainsAllNumbers_2133 {
  public boolean checkValid(int[][] matrix) {

    int n = matrix[0].length;

    Set<Integer> expected = new HashSet<>();

    for (int i = 1; i <= n; i++) {
      expected.add(i);
    }

    for (int i = 0; i < n; i++) {

      Set<Integer> row = new HashSet<>();
      Set<Integer> col = new HashSet<>();
      for (int j = 0; j < n; j++) {
        row.add(matrix[i][j]);
        col.add(matrix[j][i]);
      }

      if (!row.equals(expected) || !col.equals(expected)) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
