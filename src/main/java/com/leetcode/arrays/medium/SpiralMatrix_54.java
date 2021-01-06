package com.leetcode.arrays.medium;

// Given an m x n matrix, return all elements of the matrix in spiral order.
//
//
// Example 1:
//
//
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
//
//
// Example 2:
//
//
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics Array
// 👍 3275 👎 629

import java.util.ArrayList;
import java.util.List;
/*
 O(n*m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
 O(n*m) Memory Usage: 37.3 MB, less than 45.77% of Java online submissions for Spiral Matrix.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class SpiralMatrix_54 {
  int[][] INCREASES = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public List<Integer> spiralOrder(int[][] matrix) {
    int maxRow = matrix.length;
    int maxCol = matrix[0].length;
    int target = maxCol * maxRow;

    List<Integer> result = new ArrayList<>();
    boolean[][] visited = new boolean[maxRow][maxCol];

    int currIncrease = 0;
    int col = 0;
    int row = 0;

    while (result.size() < target) {
      visited[row][col] = true;
      result.add(matrix[row][col]);

      int newCol = col + INCREASES[currIncrease][1];
      int newRow = row + INCREASES[currIncrease][0];

      if (newRow < 0
          || newRow >= maxRow
          || newCol < 0
          || newCol >= maxCol
          || visited[newRow][newCol]) {
        currIncrease = (currIncrease + 1) % INCREASES.length;
        newCol = col + INCREASES[currIncrease][1];
        newRow = row + INCREASES[currIncrease][0];
      }
      col = newCol;
      row = newRow;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
