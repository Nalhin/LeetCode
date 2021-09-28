package com.leetcode.bfs.hard;
/*
 O(n^2*m^2) Runtime: 262 ms, faster than 47.94% of Java online submissions for Shortest Distance from All Buildings.
 O(n*m) Memory Usage: 39.1 MB, less than 73.77% of Java online submissions for Shortest Distance from All Buildings.
*/
import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings_317 {
  private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static final int EMPTY_LAND = 0;

  public int shortestDistance(int[][] grid) {
    int minDistance = Integer.MAX_VALUE;
    int rows = grid.length;
    int cols = grid[0].length;
    int houseCount = 0;

    House[][] distances = new House[rows][cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        distances[i][j] = new House();
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 1) {
          bfs(grid, distances, i, j);
          houseCount++;
        }
      }
    }

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (distances[i][j].visitedCount == houseCount) {
          minDistance = Math.min(minDistance, distances[i][j].distance);
        }
      }
    }

    if (minDistance == Integer.MAX_VALUE) {
      return -1;
    }

    return minDistance;
  }

  private void bfs(int[][] grid, House[][] distances, int row, int col) {

    int rows = grid.length;
    int cols = grid[0].length;

    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {row, col});

    boolean[][] visited = new boolean[rows][cols];
    visited[row][col] = true;

    int distance = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        int[] curr = queue.remove();
        int currRow = curr[0];
        int currCol = curr[1];

        if (grid[currRow][currCol] == EMPTY_LAND) {
          distances[currRow][currCol].distance += distance;
          distances[currRow][currCol].visitedCount += 1;
        }

        for (int[] dir : DIRECTIONS) {
          int newRow = currRow + dir[0];
          int newCol = currCol + dir[1];

          if (newRow >= 0
              && newRow < rows
              && newCol >= 0
              && newCol < cols
              && !visited[newRow][newCol]
              && grid[newRow][newCol] == EMPTY_LAND) {

            visited[newRow][newCol] = true;
            queue.add(new int[] {newRow, newCol});
          }
        }
      }

      distance++;
    }
  }

  private final class House {
    int distance = 0;
    int visitedCount = 0;
  }
}
