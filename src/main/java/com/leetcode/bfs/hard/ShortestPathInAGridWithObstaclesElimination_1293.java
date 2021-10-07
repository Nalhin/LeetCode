package com.leetcode.bfs.hard;

// You are given an m x n integer matrix grid where each cell is either 0 (empty)
// or 1 (obstacle). You can move up, down, left, or right from and to an empty
// cell in one step.
//
// Return the minimum number of steps to walk from the upper left corner (0, 0)
// to the lower right corner (m - 1, n - 1) given that you can eliminate at most k
// obstacles. If it is not possible to find such walk return -1.
//
//
// Example 1:
//
//
// Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
// Output: 6
// Explanation:
// The shortest path without eliminating any obstacle is 10.
// The shortest path with one obstacle elimination at position (3,2) is 6. Such
// path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
//
//
// Example 2:
//
//
// Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
// Output: -1
// Explanation: We need to eliminate at least two obstacles to find such a walk.
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 40
// 1 <= k <= m * n
// grid[i][j] is either 0 or 1.
// grid[0][0] == grid[m - 1][n - 1] == 0
//
/*
 O(n*m*k) Runtime: 91 ms, faster than 21.54% of Java online submissions for Shortest Path in a Grid with Obstacles Elimination.
 O(n*m*k) Memory Usage: 47.7 MB, less than 19.56% of Java online submissions for Shortest Path in a Grid with Obstacles Elimination.
*/
// Related Topics Array Breadth-First Search Matrix 👍 1441 👎 23

import java.util.*;

// leetcode submit region begin(Prohibit modification and deletion)
public class ShortestPathInAGridWithObstaclesElimination_1293 {
  private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int shortestPath(int[][] grid, int k) {
    int rows = grid.length;
    int cols = grid[0].length;

    Set<State> visited = new HashSet<>();

    Queue<State> queue = new ArrayDeque<>();
    queue.add(new State(0, 0, grid[0][0]));
    visited.add(new State(0, 0, grid[0][0]));

    int distance = 0;

    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int i = 0; i < size; i++) {
        State curr = queue.remove();

        if (curr.row == rows - 1 && curr.col == cols - 1) {
          return distance;
        }

        for (int[] direction : DIRECTIONS) {
          int newRow = curr.row + direction[0];
          int newCol = curr.col + direction[1];

          if (newRow >= 0
              && newRow < rows
              && newCol >= 0
              && newCol < cols
              && (curr.removed + grid[newRow][newCol]) <= k) {
            State newState = new State(newRow, newCol, curr.removed + grid[newRow][newCol]);
            if (visited.add(newState)) {
              queue.add(newState);
            }
          }
        }
      }
      distance++;
    }

    return -1;
  }

  private static class State {
    private final int row;
    private final int col;
    private final int removed;

    public State(int row, int col, int removed) {
      this.row = row;
      this.col = col;
      this.removed = removed;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      State state = (State) o;
      return row == state.row && col == state.col && removed == state.removed;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col, removed);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
