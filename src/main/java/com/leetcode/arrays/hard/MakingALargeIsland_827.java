package com.leetcode.arrays.hard;

// You are given an n x n binary matrix grid. You are allowed to change at most o
// ne 0 to be 1.
//
// Return the size of the largest island in grid after applying this operation.
//
//
// An island is a 4-directionally connected group of 1s.
//
//
// Example 1:
//
//
// Input: grid = [[1,0],[0,1]]
// Output: 3
// Explanation: Change one 0 to 1 and connect two 1s, then we get an island with
// area = 3.
//
//
// Example 2:
//
//
// Input: grid = [[1,1],[1,0]]
// Output: 4
// Explanation: Change the 0 to 1 and make the island bigger, only one island wit
// h area = 4.
//
// Example 3:
//
//
// Input: grid = [[1,1],[1,1]]
// Output: 4
// Explanation: Can't change any 0 to 1, only one island with area = 4.
//
//
//
// Constraints:
//
//
// n == grid.length
// n == grid[i].length
// 1 <= n <= 500
// grid[i][j] is either 0 or 1.
// Related Topics Array Depth-First Search Breadth-First Search Union Find Matrix
// 👍 1160 👎 33
/*
 O(n*m) Runtime: 85 ms, faster than 81.77% of Java online submissions for Making A Large Island.
 O(n*m) Memory Usage: 71.5 MB, less than 82.38% of Java online submissions for Making A Large Island.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland_827 {

  private final int[][] DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int largestIsland(int[][] grid) {
    boolean[][] visited = new boolean[grid.length][grid.length];
    int[][] populated = new int[grid.length][grid.length];
    int[][] populateIndices = new int[grid.length][grid.length];

    int populateIndex = 1;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (!visited[i][j] && grid[i][j] == 1) {
          int val = dfs(i, j, grid, visited);

          populateDfs(i, j, val, grid, populated, populateIndices, populateIndex);
          populateIndex++;
        }
      }
    }

    int result = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) {

          int sum = 1;
          Set<Integer> populationVisited = new HashSet<>();

          for (int[] direction : DIRECTIONS) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];

            if (newRow >= 0
                && newRow < grid.length
                && newCol >= 0
                && newCol < grid[0].length
                && populated[newRow][newCol] > 0
                && !populationVisited.contains(populateIndices[newRow][newCol])) {
              sum += populated[newRow][newCol];
              populationVisited.add(populateIndices[newRow][newCol]);
            }
          }
          result = Math.max(result, sum);
        } else {
          result = Math.max(result, populated[i][j]);
        }
      }
    }

    return result;
  }

  private int dfs(int row, int col, int[][] grid, boolean[][] visited) {
    visited[row][col] = true;
    int sum = 1;

    for (int[] direction : DIRECTIONS) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];

      if (newRow >= 0
          && newRow < grid.length
          && newCol >= 0
          && newCol < grid[0].length
          && grid[newRow][newCol] == 1
          && !visited[newRow][newCol]) {
        sum += dfs(newRow, newCol, grid, visited);
      }
    }

    return sum;
  }

  private void populateDfs(
      int row,
      int col,
      int val,
      int[][] grid,
      int[][] populated,
      int[][] populateIndices,
      int populateIndex) {

    populated[row][col] = val;
    populateIndices[row][col] = populateIndex;

    for (int[] direction : DIRECTIONS) {
      int newRow = row + direction[0];
      int newCol = col + direction[1];

      if (newRow >= 0
          && newRow < grid.length
          && newCol >= 0
          && newCol < grid[0].length
          && grid[newRow][newCol] == 1
          && populated[newRow][newCol] == 0) {
        populateDfs(newRow, newCol, val, grid, populated, populateIndices, populateIndex);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
