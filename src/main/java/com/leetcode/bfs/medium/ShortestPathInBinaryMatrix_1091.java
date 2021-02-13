package com.leetcode.bfs.medium;

// In an N by N square grid, each cell is either empty (0) or blocked (1).
//
// A clear path from top-left to bottom-right has length k if and only if it is
// composed of cells C_1, C_2, ..., C_k such that:
//
//
// Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are d
// ifferent and share an edge or corner)
// C_1 is at location (0, 0) (ie. has value grid[0][0])
// C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
// If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).
//
//
//
// Return the length of the shortest such clear path from top-left to bottom-rig
// ht. If such a path does not exist, return -1.
//
//
//
// Example 1:
//
//
// Input: [[0,1],[1,0]]
//
//
// Output: 2
//
//
//
//
// Example 2:
//
//
// Input: [[0,0,0],[1,1,0],[1,1,0]]
//
//
// Output: 4
//
//
//
//
//
//
// Note:
//
//
// 1 <= grid.length == grid[0].length <= 100
// grid[r][c] is 0 or 1
//
// Related Topics Breadth-first Search
// 👍 836 👎 63

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n * m) Runtime: 16 ms, faster than 64.66% of Java online submissions for Shortest Path in Binary Matrix.
 O(n * m) Memory Usage: 40.7 MB, less than 39.62% of Java online submissions for Shortest Path in Binary Matrix.
*/
import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestPathInBinaryMatrix_1091 {

  private final int[][] DIRECTIONS =
      new int[][] {{0, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 0}, {-1, 0}, {0, -1}};

  public int shortestPathBinaryMatrix(int[][] grid) {
    int n = grid.length;
    int m = grid[0].length;

    if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
      return -1;
    }

    Deque<int[]> deque = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][m];
    deque.push(new int[] {0, 0});
    visited[0][0] = true;
    int result = 0;

    while (!deque.isEmpty()) {
      int size = deque.size();

      for (int i = 0; i < size; i++) {
        int[] curr = deque.pop();

        if (curr[0] == (n - 1) && curr[1] == (m - 1)) {
          return result + 1;
        }

        for (int[] dir : DIRECTIONS) {
          int newX = curr[0] + dir[0];
          int newY = curr[1] + dir[1];

          if (newX >= 0
              && newX < n
              && newY >= 0
              && newY < m
              && !visited[newX][newY]
              && grid[newX][newY] == 0) {
            deque.add(new int[] {newX, newY});
            visited[newX][newY] = true;
          }
        }
      }
      result++;
    }

    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
