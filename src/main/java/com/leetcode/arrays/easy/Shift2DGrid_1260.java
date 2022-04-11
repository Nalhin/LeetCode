package com.leetcode.arrays.easy;

// Given a 2D grid of size m x n and an integer k. You need to shift the grid k
// times.
//
// In one shift operation:
//
//
// Element at grid[i][j] moves to grid[i][j + 1].
// Element at grid[i][n - 1] moves to grid[i + 1][0].
// Element at grid[m - 1][n - 1] moves to grid[0][0].
//
//
// Return the 2D grid after applying shift operation k times.
//
//
// Example 1:
//
//
// Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
// Output: [[9,1,2],[3,4,5],[6,7,8]]
//
//
// Example 2:
//
//
// Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
// Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
//
//
// Example 3:
//
//
// Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
// Output: [[1,2,3],[4,5,6],[7,8,9]]
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m <= 50
// 1 <= n <= 50
// -1000 <= grid[i][j] <= 1000
// 0 <= k <= 100
//
// Related Topics Array Matrix Simulation 👍 842 👎 219
/*
  O(n * m) Runtime: 14 ms, faster than 27.52% of Java online submissions for Shift 2D Grid.
  O(n * m) Memory Usage: 54.8 MB, less than 48.06% of Java online submissions for Shift 2D Grid.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid_1260 {
  public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    int n = grid.length;
    int m = grid[0].length;

    int offset = k % (n * m);

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> curr = new ArrayList<>();
    for (int i = 0; i < n * m; i++) {

      if (curr.size() == m) {
        result.add(curr);
        curr = new ArrayList<>();
      }

      int position = (i + (n * m) - offset) % (n * m);

      int currRow = position / m;
      int currCol = position % m;

      curr.add(grid[currRow][currCol]);
    }

    result.add(curr);

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
