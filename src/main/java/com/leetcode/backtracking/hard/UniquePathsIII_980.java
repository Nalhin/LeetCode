package com.leetcode.backtracking.hard;

// You are given an m x n integer array grid where grid[i][j] could be:
//
//
// 1 representing the starting square. There is exactly one starting square.
// 2 representing the ending square. There is exactly one ending square.
// 0 representing empty squares we can walk over.
// -1 representing obstacles that we cannot walk over.
//
//
// Return the number of 4-directional walks from the starting square to the
// ending square, that walk over every non-obstacle square exactly once.
//
//
// Example 1:
//
//
// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
// Output: 2
// Explanation: We have the following two paths:
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
// 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
//
//
// Example 2:
//
//
// Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
// Output: 4
// Explanation: We have the following four paths:
// 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
// 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
// 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
// 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
//
//
// Example 3:
//
//
// Input: grid = [[0,1],[2,0]]
// Output: 0
// Explanation: There is no path that walks over every empty square exactly once.
//
// Note that the starting and ending square can be anywhere in the grid.
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 20
// 1 <= m * n <= 20
// -1 <= grid[i][j] <= 2
// There is exactly one starting cell and one ending cell.
//
// Related Topics Array Backtracking Bit Manipulation Matrix 👍 2133 👎 112
/*
 O(3^(n*m))Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths III.
 O(n*m) Memory Usage: 36.4 MB, less than 75.22% of Java online submissions for Unique Paths III.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class UniquePathsIII_980 {
  private static final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int uniquePathsIII(int[][] grid) {
    int startRow = -1;
    int startCol = -1;

    int toVisit = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          startRow = i;
          startCol = j;
        }
        if (grid[i][j] != -1 && grid[i][j] != 1) {
          toVisit++;
        }
      }
    }

    return backtrack(startRow, startCol, toVisit, grid, new boolean[grid.length][grid[0].length]);
  }

  private int backtrack(int row, int col, int toVisit, int[][] grid, boolean[][] visited) {
    if (row < 0
        || row >= grid.length
        || col < 0
        || col >= grid[0].length
        || grid[row][col] == -1
        || visited[row][col]) {
      return 0;
    }
    if (grid[row][col] == 2) {
      if (toVisit == 0) {
        return 1;
      }
      return 0;
    }
    visited[row][col] = true;

    int result = 0;
    for (int[] dir : DIRECTIONS) {
      result += backtrack(row + dir[0], col + dir[1], toVisit - 1, grid, visited);
    }

    visited[row][col] = false;

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
