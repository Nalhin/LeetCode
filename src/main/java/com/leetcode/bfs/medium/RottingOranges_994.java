package com.leetcode.bfs.medium;

// You are given an m x n grid where each cell can have one of three values:
//
//
// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
//
//
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten
// orange becomes rotten.
//
// Return the minimum number of minutes that must elapse until no cell has a
// fresh orange. If this is impossible, return -1.
//
//
// Example 1:
//
//
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4
//
//
// Example 2:
//
//
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never
// rotten, because rotting only happens 4-directionally.
//
//
// Example 3:
//
//
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer
// is just 0.
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 10
// grid[i][j] is 0, 1, or 2.
//
// Related Topics Array Breadth-First Search Matrix 👍 4880 👎 240
/*
 O(n*m) Runtime: 3 ms, faster than 68.86% of Java online submissions for Rotting Oranges.
 O(n*m) Memory Usage: 38.7 MB, less than 54.07% of Java online submissions for Rotting Oranges.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class RottingOranges_994 {
  private final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int orangesRotting(int[][] grid) {
    int fresh = 0;
    Deque<int[]> deque = new ArrayDeque<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 2) {
          deque.add(new int[] {i, j});
          visited[i][j] = true;
        }
        if (grid[i][j] == 1) {
          fresh++;
        }
      }
    }

    int result = 0;
    while (!deque.isEmpty() && fresh > 0) {
      int size = deque.size();

      for (int i = 0; i < size; i++) {
        int[] curr = deque.remove();

        for (int[] direction : DIRECTIONS) {
          int newX = curr[0] + direction[0];
          int newY = curr[1] + direction[1];

          if (newX >= 0
              && newX < grid.length
              && newY >= 0
              && newY < grid[0].length
              && grid[newX][newY] == 1
              && !visited[newX][newY]) {
            deque.add(new int[] {newX, newY});
            visited[newX][newY] = true;
            fresh--;
          }
        }
      }

      result++;
    }

    return fresh == 0 ? result : -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
