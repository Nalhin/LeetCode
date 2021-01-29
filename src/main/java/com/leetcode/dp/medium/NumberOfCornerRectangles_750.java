package com.leetcode.dp.medium;

// Given a grid where each entry is only 0 or 1, find the number of corner rectan
// gles.
//
// A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rec
// tangle. Note that only the corners need to have the value 1. Also, all four 1s u
// sed must be distinct.
//
//
//
// Example 1:
//
//
// Input: grid =
// [[1, 0, 0, 1, 0],
// [0, 0, 1, 0, 1],
// [0, 0, 0, 1, 0],
// [1, 0, 1, 0, 1]]
// Output: 1
// Explanation: There is only one corner rectangle, with corners grid[1][2], grid
// [1][4], grid[3][2], grid[3][4].
//
//
//
//
// Example 2:
//
//
// Input: grid =
// [[1, 1, 1],
// [1, 1, 1],
// [1, 1, 1]]
// Output: 9
// Explanation: There are four 2x2 rectangles, four 2x3 and 3x2 rectangles, and o
// ne 3x3 rectangle.
//
//
//
//
// Example 3:
//
//
// Input: grid =
// [[1, 1, 1, 1]]
// Output: 0
// Explanation: Rectangles must have four distinct corners.
//
//
//
//
// Note:
//
//
// The number of rows and columns of grid will each be in the range [1, 200].
// Each grid[i][j] will be either 0 or 1.
// The number of 1s in the grid will be at most 6000.
//
//
//
// Related Topics Dynamic Programming
// 👍 474 👎 69

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n^2*m) Runtime: 65 ms, faster than 55.15% of Java online submissions for Number Of Corner Rectangles.
 O(1) Memory Usage: 48.2 MB, less than 25.77% of Java online submissions for Number Of Corner Rectangles.
*/
public class NumberOfCornerRectangles_750 {
  public int countCornerRectangles(int[][] grid) {
    int result = 0;
    int rows = grid.length;
    int cols = grid[0].length;

    for (int i = 0; i < rows; i++) {
      for (int j = i + 1; j < rows; j++) {
        int counter = 0;
        for (int k = 0; k < cols; k++) {
          if (grid[i][k] == 1 && grid[j][k] == 1) {
            counter++;
          }
        }
        result += counter * (counter - 1) / 2;
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
