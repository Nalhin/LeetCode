package com.leetcode.graph.medium;

// You are a hiker preparing for an upcoming hike. You are given heights, a 2D ar
// ray of size rows x columns, where heights[row][col] represents the height of cel
// l (row, col). You are situated in the top-left cell, (0, 0), and you hope to tra
// vel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can mov
// e up, down, left, or right, and you wish to find a route that requires the minim
// um effort.
//
// A route's effort is the maximum absolute difference in heights between two co
// nsecutive cells of the route.
//
// Return the minimum effort required to travel from the top-left cell to the bo
// ttom-right cell.
//
//
// Example 1:
//
//
//
//
// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
// Output: 2
// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 i
// n consecutive cells.
// This is better than the route of [1,2,2,2,5], where the maximum absolute diffe
// rence is 3.
//
//
// Example 2:
//
//
//
//
// Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
// Output: 1
// Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 i
// n consecutive cells, which is better than route [1,3,5,3,5].
//
//
// Example 3:
//
//
// Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
//
// Output: 0
// Explanation: This route does not require any effort.
//
//
//
// Constraints:
//
//
// rows == heights.length
// columns == heights[i].length
// 1 <= rows, columns <= 100
// 1 <= heights[i][j] <= 106
//
// Related Topics Binary Search Depth-first Search Union Find Graph
// 👍 651 👎 24

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/*
  O(nm(lognm)) Runtime: 44 ms, faster than 66.14% of Java online submissions for Path With Minimum Effort.
  O(nm)        Memory Usage: 39.8 MB, less than 53.73% of Java online submissions for Path With Minimum Effort.
*/
public class PathWithMinimumEffort_1631 {
  private final int[][] DIRECTIONS = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public int minimumEffortPath(int[][] heights) {

    int rows = heights.length;
    int cols = heights[0].length;

    int[][] diffMatrix = new int[rows][cols];
    for (int[] row : diffMatrix) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    diffMatrix[0][0] = 0;

    boolean[][] visited = new boolean[rows][cols];

    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
    pq.add(new int[] {0, 0, 0});

    while (!pq.isEmpty()) {
      int[] entry = pq.poll();
      int row = entry[0];
      int col = entry[1];

      visited[row][col] = true;

      if (row == (rows - 1) && col == (cols - 1)) {
        return entry[2];
      }

      for (int[] direction : DIRECTIONS) {
        int newRow = row + direction[0];
        int newCol = col + direction[1];

        if (newRow >= 0
            && newRow < rows
            && newCol >= 0
            && newCol < cols
            && !visited[newRow][newCol]) {
          int diff = Math.abs(heights[row][col] - heights[newRow][newCol]);
          int max = Math.max(diff, diffMatrix[row][col]);
          if (diffMatrix[newRow][newCol] > max) {
            diffMatrix[newRow][newCol] = max;
            pq.add(new int[] {newRow, newCol, max});
          }
        }
      }
    }

    return 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
