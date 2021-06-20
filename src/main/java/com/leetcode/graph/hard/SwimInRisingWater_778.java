package com.leetcode.graph.hard;

// On an N x N grid, each square grid[i][j] represents the elevation at that poin
// t (i,j).
//
// Now rain starts to fall. At time t, the depth of the water everywhere is t. Y
// ou can swim from a square to another 4-directionally adjacent square if and only
// if the elevation of both squares individually are at most t. You can swim infin
// ite distance in zero time. Of course, you must stay within the boundaries of the
// grid during your swim.
//
// You start at the top left square (0, 0). What is the least time until you can
// reach the bottom right square (N-1, N-1)?
//
// Example 1:
//
//
// Input: [[0,2],[1,3]]
// Output: 3
// Explanation:
// At time 0, you are in grid location (0, 0).
// You cannot go anywhere else because 4-directionally adjacent neighbors have a
// higher elevation than t = 0.
//
// You cannot reach point (1, 1) until time 3.
// When the depth of water is 3, we can swim anywhere inside the grid.
//
//
// Example 2:
//
//
// Input: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,
// 7,6]]
// Output: 16
// Explanation:
// 0  1  2  3  4
// 24 23 22 21  5
// 12 13 14 15 16
// 11 17 18 19 20
// 10  9  8  7  6
//
// The final route is marked in bold.
// We need to wait until time 16 so that (0, 0) and (4, 4) are connected.
//
//
// Note:
//
//
// 2 <= N <= 50.
// grid[i][j] is a permutation of [0, ..., N*N - 1].
//
// Related Topics Binary Search Heap Depth-first Search Union Find
// 👍 1026 👎 78
/*
 O(n^2log(n^2)) Runtime: 14 ms, faster than 44.12% of Java online submissions for Swim in Rising Water.
 O(n^2) Memory Usage: 39.3 MB, less than 35.35% of Java online submissions for Swim in Rising Water.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class SwimInRisingWater_778 {

  private static final int[][] NEIGHBOURS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public int swimInWater(int[][] grid) {
    Set<Entry> visited = new HashSet<>();
    Queue<Entry> pq = new PriorityQueue<>();
    int minSoFar = grid[0][0];
    pq.add(new Entry(0, 0, grid[0][0]));

    while (!pq.isEmpty()) {
      Entry curr = pq.poll();
      minSoFar = Math.max(minSoFar, curr.value);

      if (curr.x == (grid.length - 1) && curr.y == (grid[0].length - 1)) {
        return minSoFar;
      }

      for (int[] neighbour : NEIGHBOURS) {
        int newX = curr.x + neighbour[0];
        int newY = curr.y + neighbour[1];

        if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
          continue;
        }
        Entry entry = new Entry(newX, newY, grid[newX][newY]);
        if (!visited.contains(entry)) {
          pq.add(entry);
          visited.add(entry);
        }
      }
    }
    return -1;
  }

  private static final class Entry implements Comparable<Entry> {
    private final int x;
    private final int y;
    private final int value;

    private Entry(int x, int y, int value) {
      this.x = x;
      this.y = y;
      this.value = value;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Entry entry = (Entry) o;
      return x == entry.x && y == entry.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Entry entry) {
      return Integer.compare(value, entry.value);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
