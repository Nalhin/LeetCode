package com.leetcode.arrays.hard;

import java.util.ArrayList;
import java.util.List;
/*
 O(nm) Runtime: 6 ms, faster than 68.01% of Java online submissions for Best Meeting Point.
 O(nm) Memory Usage: 40.3 MB, less than 66.41% of Java online submissions for Best Meeting Point.
*/
public class BestMeetingPoint_296 {

  public int minTotalDistance(int[][] grid) {
    List<Integer> rows = findRows(grid);
    List<Integer> cols = findCols(grid);

    int row = rows.get(rows.size() / 2);
    int col = cols.get(cols.size() / 2);

    return minDistance(rows, row) + minDistance(cols, col);
  }

  private int minDistance(List<Integer> points, int source) {
    int distance = 0;
    for (int point : points) {
      distance += Math.abs(point - source);
    }
    return distance;
  }

  private List<Integer> findRows(int[][] grid) {
    List<Integer> rows = new ArrayList<>();
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          rows.add(row);
        }
      }
    }
    return rows;
  }

  private List<Integer> findCols(int[][] grid) {
    List<Integer> cols = new ArrayList<>();
    for (int col = 0; col < grid[0].length; col++) {
      for (int[] rows : grid) {
        if (rows[col] == 1) {
          cols.add(col);
        }
      }
    }
    return cols;
  }
}
