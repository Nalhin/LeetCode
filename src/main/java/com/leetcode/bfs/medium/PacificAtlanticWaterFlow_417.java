package com.leetcode.bfs.medium;

// Given an m x n matrix of non-negative integers representing the height of each
// unit cell in a continent, the "Pacific ocean" touches the left and top edges of
// the matrix and the "Atlantic ocean" touches the right and bottom edges.
//
// Water can only flow in four directions (up, down, left, or right) from a cell
// to another one with height equal or lower.
//
// Find the list of grid coordinates where water can flow to both the Pacific an
// d Atlantic ocean.
//
// Note:
//
//
// The order of returned grid coordinates does not matter.
// Both m and n are less than 150.
//
//
//
//
// Example:
//
//
// Given the following 5x5 matrix:
//
//  Pacific ~   ~   ~   ~   ~
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//
// Return:
//
// [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with paren
// theses in above matrix).
//
//
//
// Related Topics Depth-first Search Breadth-first Search
// 👍 1957 👎 491
/*
 O(n * m) Runtime: 8 ms, faster than 44.83% of Java online submissions for Pacific Atlantic Water Flow.
 O(n * m) Memory Usage: 40.3 MB, less than 51.30% of Java online submissions for Pacific Atlantic Water Flow.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class PacificAtlanticWaterFlow_417 {
  private final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public List<List<Integer>> pacificAtlantic(int[][] matrix) {
    if (matrix.length == 0) {
      return Collections.emptyList();
    }
    int rows = matrix.length;
    int cols = matrix[0].length;
    List<int[]> atlanticStart = new ArrayList<>();
    List<int[]> pacificStart = new ArrayList<>();

    for (int i = 0; i < rows; i++) {
      pacificStart.add(new int[] {i, 0});
      atlanticStart.add(new int[] {i, cols - 1});
    }
    for (int i = 0; i < cols; i++) {
      pacificStart.add(new int[] {0, i});
      atlanticStart.add(new int[] {rows - 1, i});
    }

    boolean[][] pacific = bfs(matrix, pacificStart);
    boolean[][] atlantic = bfs(matrix, atlanticStart);

    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          result.add(List.of(i, j));
        }
      }
    }
    return result;
  }

  private boolean[][] bfs(int[][] matrix, List<int[]> starts) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean[][] visited = new boolean[rows][cols];

    Deque<int[]> deque = new ArrayDeque<>(starts);
    for (int[] start : starts) {
      visited[start[0]][start[1]] = true;
    }

    while (!deque.isEmpty()) {
      int[] curr = deque.poll();
      int row = curr[0];
      int col = curr[1];

      for (int[] dir : DIRECTIONS) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];

        if (newRow >= 0
            && newRow < rows
            && newCol >= 0
            && newCol < cols
            && matrix[newRow][newCol] >= matrix[row][col]
            && !visited[newRow][newCol]) {
          visited[newRow][newCol] = true;
          deque.add(new int[] {newRow, newCol});
        }
      }
    }

    return visited;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
