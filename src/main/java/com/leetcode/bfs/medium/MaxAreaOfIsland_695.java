package com.leetcode.bfs.medium;

// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (r
// epresenting land) connected 4-directionally (horizontal or vertical.) You may as
// sume all four edges of the grid are surrounded by water.
//
// Find the maximum area of an island in the given 2D array. (If there is no isl
// and, the maximum area is 0.)
//
// Example 1:
//
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
// Given the above grid, return 6. Note the answer is not 11, because the island
// must be connected 4-directionally.
//
// Example 2:
//
//
// [[0,0,0,0,0,0,0,0]]
// Given the above grid, return 0.
//
// Note: The length of each dimension in the given grid does not exceed 50.
// Related Topics Array Depth-first Search
// 👍 2564 👎 88

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(n*m) Runtime: 5 ms, faster than 14.98% of Java online submissions for Max Area of Island.
 O(n*m) Memory Usage: 38.6 MB, less than 99.98% of Java online submissions for Max Area of Island.
*/
public class MaxAreaOfIsland_695 {
  private final int LAND = 1;
  private final int[][] NEIGHBOURS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int maxAreaOfIsland(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    int maxSize = 0;

    Deque<int[]> deque = new ArrayDeque<>();

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && grid[i][j] == LAND) {
          int size = 0;
          visited[i][j] = true;
          deque.add(new int[] {i, j});

          while (!deque.isEmpty()) {
            int[] position = deque.pop();
            size++;

            for (int[] neighbour : NEIGHBOURS) {
              int newRow = position[0] + neighbour[0];
              int newCol = position[1] + neighbour[1];

              if (newRow >= 0
                  && newRow < n
                  && newCol >= 0
                  && newCol < m
                  && grid[newRow][newCol] == LAND
                  && !visited[newRow][newCol]) {
                deque.add(new int[] {newRow, newCol});
                visited[newRow][newCol] = true;
              }
            }
          }
          maxSize = Math.max(maxSize, size);
        }
      }
    }
    return maxSize;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
