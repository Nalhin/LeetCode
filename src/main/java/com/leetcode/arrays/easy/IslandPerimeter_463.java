package com.leetcode.arrays.easy;

// You are given row x col grid representing a map where grid[i][j] = 1 represent
// s land and grid[i][j] = 0 represents water.
//
// Grid cells are connected horizontally/vertically (not diagonally). The grid i
// s completely surrounded by water, and there is exactly one island (i.e., one or
// more connected land cells).
//
// The island doesn't have "lakes", meaning the water inside isn't connected to
// the water around the island. One cell is a square with side length 1. The grid i
// s rectangular, width and height don't exceed 100. Determine the perimeter of the
// island.
//
//
// Example 1:
//
//
// Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
// Output: 16
// Explanation: The perimeter is the 16 yellow stripes in the image above.
//
//
// Example 2:
//
//
// Input: grid = [[1]]
// Output: 4
//
//
// Example 3:
//
//
// Input: grid = [[1,0]]
// Output: 4
//
//
//
// Constraints:
//
//
// row == grid.length
// col == grid[i].length
// 1 <= row, col <= 100
// grid[i][j] is 0 or 1.
//
// Related Topics Hash Table
// 👍 2360 👎 129

// leetcode submit region begin(Prohibit modification and deletion)

/*
 O(n*m) Runtime: 7 ms, faster than 44.57% of Java online submissions for Island Perimeter.
 O(1) Memory Usage: 40 MB, less than 10.21% of Java online submissions for Island Perimeter.
*/
public class IslandPerimeter_463 {
  private final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int islandPerimeter(int[][] grid) {
    int ans = 0;
    for (int x = 0; x < grid.length; x++) {
      int[] row = grid[x];
      for (int y = 0; y < row.length; y++) {

        if (grid[x][y] != 1) {
          continue;
        }

        for (int[] dir : DIRECTIONS) {
          int newX = x + dir[0];
          int newY = y + dir[1];
          if (newX < 0
              || newX >= grid.length
              || newY < 0
              || newY >= row.length
              || grid[newX][newY] == 0) {
            ans++;
          }
        }
      }
    }
    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
