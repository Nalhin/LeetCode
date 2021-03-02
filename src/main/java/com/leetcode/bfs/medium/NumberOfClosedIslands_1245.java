package com.leetcode.bfs.medium;

// Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal 4
// -directionally connected group of 0s and a closed island is an island totally (a
// ll left, top, right, bottom) surrounded by 1s.
//
// Return the number of closed islands.
//
//
// Example 1:
//
//
//
//
// Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,
// 0,1,0,1],[1,1,1,1,1,1,1,0]]
// Output: 2
// Explanation:
// Islands in gray are closed because they are completely surrounded by water (gr
// oup of 1s).
//
// Example 2:
//
//
//
//
// Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
// Output: 1
//
//
// Example 3:
//
//
// Input: grid = [[1,1,1,1,1,1,1],
//                [1,0,0,0,0,0,1],
//                [1,0,1,1,1,0,1],
//                [1,0,1,0,1,0,1],
//                [1,0,1,1,1,0,1],
//                [1,0,0,0,0,0,1],
//               [1,1,1,1,1,1,1]]
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= grid.length, grid[0].length <= 100
// 0 <= grid[i][j] <=1
//
// Related Topics Depth-first Search
// 👍 727 👎 21

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Queue;
/*
 O(n*m) Runtime: 3 ms, faster than 30.74% of Java online submissions for Number of Closed Islands.
 O(n*m) Memory Usage: 39 MB, less than 96.09% of Java online submissions for Number of Closed Islands.
*/
public class NumberOfClosedIslands_1245 {
  private final int[][] DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int closedIsland(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    int result = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (!visited[i][j] && grid[i][j] == 0) {
          if (isClosedIsland(new int[] {i, j}, grid, visited)) {
            result++;
          }
        }
      }
    }
    return result;
  }

  private boolean isClosedIsland(int[] coords, int[][] grid, boolean[][] visited) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(coords);
    visited[coords[0]][coords[1]] = true;
    boolean isOpen = true;

    while (!queue.isEmpty()) {
      int[] last = queue.remove();

      if (last[0] == 0
          || last[0] == grid.length - 1
          || last[1] == 0
          || last[1] == grid[0].length - 1) {
        isOpen = false;
      }

      for (int[] direction : DIRECTIONS) {
        int newX = last[0] + direction[0];
        int newY = last[1] + direction[1];

        if (newX >= 0
            && newX < grid.length
            && newY >= 0
            && newY < grid[0].length
            && !visited[newX][newY]
            && grid[newX][newY] == 0) {
          visited[newX][newY] = true;
          queue.add(new int[] {newX, newY});
        }
      }
    }
    return isOpen;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
