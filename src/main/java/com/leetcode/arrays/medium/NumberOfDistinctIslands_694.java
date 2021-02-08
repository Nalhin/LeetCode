package com.leetcode.arrays.medium;

// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (r
// epresenting land) connected 4-directionally (horizontal or vertical.) You may as
// sume all four edges of the grid are surrounded by water.
//
// Count the number of distinct islands. An island is considered to be the same
// as another if and only if one island can be translated (and not rotated or refle
// cted) to equal the other.
//
// Example 1:
//
// 11000
// 11000
// 00011
// 00011
//
// Given the above grid map, return 1.
//
//
// Example 2:
// 11011
// 10000
// 00001
// 11011
// Given the above grid map, return 3.
// Notice that:
//
// 11
// 1
//
// and
//
// 1
// 11
//
// are considered different island shapes, because we do not consider reflection
/// rotation.
//
//
// Note:
// The length of each dimension in the given grid does not exceed 50.
// Related Topics Hash Table Depth-first Search Breadth-first Search
// 👍 1117 👎 69

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
/*
 O(nm) Runtime: 11 ms, faster than 41.23% of Java online submissions for Number of Distinct Islands.
 O(nm) Memory Usage: 39.3 MB, less than 97.91% of Java online submissions for Number of Distinct Islands.
*/
public class NumberOfDistinctIslands_694 {
  private final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  private final int ISLAND = 1;

  public int numDistinctIslands(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    Set<String> shapes = new HashSet<>();
    boolean[][] visited = new boolean[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == ISLAND && !visited[i][j]) {

          Deque<int[]> deque = new ArrayDeque<>();
          deque.add(new int[] {i, j, 0, 0});
          StringBuilder sb = new StringBuilder();

          while (!deque.isEmpty()) {
            int[] prev = deque.pop();

            sb.append(prev[2]);
            sb.append("#");
            sb.append(prev[3]);
            sb.append("_");

            for (int[] dir : DIRECTIONS) {
              int newX = prev[0] + dir[0];
              int newY = prev[1] + dir[1];

              if (newX >= 0
                  && newX < n
                  && newY >= 0
                  && newY < m
                  && !visited[newX][newY]
                  && grid[newX][newY] == ISLAND) {
                deque.push(new int[] {newX, newY, prev[2] + dir[0], prev[3] + dir[1]});
                visited[newX][newY] = true;
              }
            }
          }

          shapes.add(sb.toString());
        }
      }
    }

    return shapes.size();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
