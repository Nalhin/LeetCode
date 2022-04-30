package com.leetcode.arrays.medium;

// You are given two integers m and n representing a 0-indexed m x n grid. You
// are also given two 2D integer arrays guards and walls where guards[i] = [rowi,
// coli] and walls[j] = [rowj, colj] represent the positions of the iᵗʰ guard and jᵗʰ
// wall respectively.
//
// A guard can see every cell in the four cardinal directions (north, east,
// south, or west) starting from their position unless obstructed by a wall or another
// guard. A cell is guarded if there is at least one guard that can see it.
//
// Return the number of unoccupied cells that are not guarded.
//
//
// Example 1:
//
//
// Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//
// Output: 7
// Explanation: The guarded and unguarded cells are shown in red and green
// respectively in the above diagram.
// There are a total of 7 unguarded cells, so we return 7.
//
//
// Example 2:
//
//
// Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
// Output: 4
// Explanation: The unguarded cells are shown in green in the above diagram.
// There are a total of 4 unguarded cells, so we return 4.
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 10⁵
// 2 <= m * n <= 10⁵
// 1 <= guards.length, walls.length <= 5 * 10⁴
// 2 <= guards.length + walls.length <= m * n
// guards[i].length == walls[j].length == 2
// 0 <= rowi, rowj < m
// 0 <= coli, colj < n
// All the positions in guards and walls are unique.
//
// 👍 57 👎 9
/*
 O(n * m) Runtime: 72 ms, faster than 100.00% of Java online submissions for Count Unguarded Cells in the Grid.
 O(n * m) Memory Usage: 123.8 MB, less than 50.00% of Java online submissions for Count Unguarded Cells in the Grid.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class CountUnguardedCellsInTheGrid_2257 {

  private static final int WALL = 2;
  private static final int GUARD = 3;

  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

    int[][] guarded = new int[m][n];

    for (int[] wall : walls) {
      guarded[wall[0]][wall[1]] = WALL;
    }

    for (int[] guard : guards) {
      guarded[guard[0]][guard[1]] = GUARD;
    }

    for (int[] guard : guards) {
      findGuarded(new int[] {guard[0], guard[1] + 1}, guarded, new int[] {0, 1});
      findGuarded(new int[] {guard[0], guard[1] - 1}, guarded, new int[] {0, -1});
      findGuarded(new int[] {guard[0] + 1, guard[1]}, guarded, new int[] {1, 0});
      findGuarded(new int[] {guard[0] - 1, guard[1]}, guarded, new int[] {-1, 0});
    }

    int result = 0;
    for (int[] row : guarded) {
      for (int cell : row) {
        if (cell == 0) {
          result++;
        }
      }
    }

    return result;
  }

  private void findGuarded(int[] cell, int[][] guarded, int[] inc) {
    while (cell[0] >= 0
        && cell[0] < guarded.length
        && cell[1] >= 0
        && cell[1] < guarded[0].length) {

      if (guarded[cell[0]][cell[1]] == 2 || guarded[cell[0]][cell[1]] == 3) {
        return;
      }

      guarded[cell[0]][cell[1]] = 1;

      cell = new int[] {cell[0] + inc[0], cell[1] + inc[1]};
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
