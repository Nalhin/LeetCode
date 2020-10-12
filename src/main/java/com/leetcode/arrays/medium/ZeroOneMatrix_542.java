package com.leetcode.arrays.medium;

// Given a matrix consists of 0 and 1, find the distance of the nearest 0 for eac
// h cell.
//
// The distance between two adjacent cells is 1.
//
//
//
// Example 1:
//
//
// Input:
// [[0,0,0],
// [0,1,0],
// [0,0,0]]
//
// Output:
// [[0,0,0],
//  [0,1,0],
//  [0,0,0]]
//
//
// Example 2:
//
//
// Input:
// [[0,0,0],
// [0,1,0],
// [1,1,1]]
//
// Output:
// [[0,0,0],
// [0,1,0],
// [1,2,1]]
//
//
//
//
// Note:
//
//
// The number of elements of the given matrix will not exceed 10,000.
// There are at least one 0 in the given matrix.
// The cells are adjacent in only four directions: up, down, left and right.
//
// Related Topics Depth-first Search Breadth-first Search
// 👍 1794 👎 114

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class ZeroOneMatrix_542 {

  int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int[][] updateMatrix(int[][] matrix) {
    Deque<int[]> deque = new ArrayDeque<>();
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == 0) {
          deque.push(new int[] {i, j});
        }
      }
    }

    while (!deque.isEmpty()) {
      int[] point = deque.poll();

      int x = point[0];
      int y = point[1];

      for (int[] dir : directions) {
        int newX = x + dir[0];
        int newY = y + dir[1];

        if ((newX >= 0 && newX < matrix.length)
            && (newY >= 0 && newY < matrix[0].length)
            && matrix[newX][newY] != 0
            && !visited[newX][newY]) {
          deque.add(new int[] {newX, newY});
          visited[newX][newY] = true;
          matrix[newX][newY] = matrix[x][y] + 1;
        }
      }
    }

    return matrix;
  }
}
/*
O(n) Runtime: 15 ms, faster than 56.57% of Java online submissions for 01 Matrix.
O(n) Memory Usage: 42.7 MB, less than 6.47% of Java online submissions for 01 Matrix.
*/
// leetcode submit region end(Prohibit modification and deletion)
