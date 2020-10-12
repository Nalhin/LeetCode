package com.leetcode.arrays.medium;

// Given a 2d grid map of '1's (land) and '0's (water), count the number of islan
// ds. An island is surrounded by water and is formed by connecting adjacent lands
// horizontally or vertically. You may assume all four edges of the grid are all su
// rrounded by water.
//
//
// Example 1:
//
//
// Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
// ]
// Output: 1
//
//
// Example 2:
//
//
// Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
// ]
// Output: 3
//
// Related Topics Depth-first Search Breadth-first Search Union Find
// 👍 6592 👎 214

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfIslands_200 {
  private final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private final char VISITED = '0';
  private final char UNVISITED = '1';

  public int numIslands(char[][] grid) {
    if (grid.length <= 0) {
      return 0;
    }

    Deque<Integer> queue = new ArrayDeque<>();
    int columns = grid[0].length;
    int rows = grid.length;
    int result = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == UNVISITED) {
          result++;
          grid[i][j] = VISITED;
          queue.add(i * columns + j);
        }
        while (!queue.isEmpty()) {
          int entry = queue.poll();
          int x = entry / columns;
          int y = entry % columns;
          for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if ((newX >= 0 && newX < rows)
                && newY >= 0
                && newY < columns
                && grid[newX][newY] == UNVISITED) {
              grid[newX][newY] = VISITED;
              queue.add(newX * columns + newY);
            }
          }
        }
      }
    }
    return result;
  }
}
/*
 O(n * m) Runtime: 4 ms, faster than 21.70% of Java online submissions for Number of Islands.
 O(min(m,n)) Memory Usage: 41.2 MB, less than 18.00% of Java online submissions for Number of Islands.
 where:
 n * m - grid size
*/
// leetcode submit region end(Prohibit modification and deletion)
