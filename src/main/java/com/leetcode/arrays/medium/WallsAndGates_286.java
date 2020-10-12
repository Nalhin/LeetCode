package com.leetcode.arrays.medium;

// You are given a m x n 2D grid initialized with these three possible values.
//
//
// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to
// represent INF as you may assume that the distance to a gate is less than 2147483
// 647.
//
//
// Fill each empty room with the distance to its nearest gate. If it is impossib
// le to reach a gate, it should be filled with INF.
//
// Example:
//
// Given the 2D grid:
//
//
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//  0  -1 INF INF
//
//
// After running your function, the 2D grid should be:
//
//
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4
//
// Related Topics Breadth-first Search
// 👍 1322 👎 16

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class WallsAndGates_286 {
  private final int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private final int GATE = 0;
  private final int EMPTY = Integer.MAX_VALUE;

  public void wallsAndGates(int[][] rooms) {
    if (rooms.length <= 0) {
      return;
    }
    Deque<int[]> queue = new ArrayDeque<>();

    for (int x = 0; x < rooms.length; x++) {
      for (int y = 0; y < rooms[x].length; y++) {
        if (rooms[x][y] == GATE) {
          queue.add(new int[] {x, y});
        }
      }
    }
    while (!queue.isEmpty()) {
      int[] pos = queue.poll();
      for (int[] dir : directions) {
        int newX = pos[0] + dir[0];
        int newY = pos[1] + dir[1];
        if ((newX >= 0 && newX < rooms.length)
            && (newY >= 0 && newY < rooms[0].length)
            && rooms[newX][newY] == EMPTY) {
          queue.add(new int[] {newX, newY});
          rooms[newX][newY] = rooms[pos[0]][pos[1]] + 1;
        }
      }
    }
  }
}
/*

 O(m * n) Runtime: 6 ms, faster than 82.84% of Java online submissions for Walls and Gates.
 O(m * n) Memory Usage: 42.5 MB, less than 10.27% of Java online submissions for Walls and Gates.
 where:
 m * n - dimensions
*/
// leetcode submit region end(Prohibit modification and deletion)
