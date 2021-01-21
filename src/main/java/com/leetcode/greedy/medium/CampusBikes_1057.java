package com.leetcode.greedy.medium;

// On a campus represented as a 2D grid, there are N workers and M bikes, with N
// <= M. Each worker and bike is a 2D coordinate on this grid.
//
// Our goal is to assign a bike to each worker. Among the available bikes and wo
// rkers, we choose the (worker, bike) pair with the shortest Manhattan distance be
// tween each other, and assign the bike to that worker. (If there are multiple (wo
// rker, bike) pairs with the same shortest Manhattan distance, we choose the pair
// with the smallest worker index; if there are multiple ways to do that, we choose
// the pair with the smallest bike index). We repeat this process until there are
// no available workers.
//
// The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p
// 1.x - p2.x| + |p1.y - p2.y|.
//
// Return a vector ans of length N, where ans[i] is the index (0-indexed) of the
// bike that the i-th worker is assigned to.
//
//
//
// Example 1:
//
//
//
//
// Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
// Output: [1,0]
// Explanation:
// Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assi
// gned Bike 1. So the output is [1, 0].
//
//
// Example 2:
//
//
//
//
// Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
// Output: [0,2,1]
// Explanation:
// Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance
// to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. S
// o the output is [0,2,1].
//
//
//
//
// Note:
//
//
// 0 <= workers[i][j], bikes[i][j] < 1000
// All worker and bike locations are distinct.
// 1 <= workers.length <= bikes.length <= 1000
//
// Related Topics Greedy Sort
// 👍 625 👎 111

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(mn)mn) Runtime: 785 ms, faster than 36.46% of Java online submissions for Campus Bikes.
 O(m*n) Memory Usage: 86.6 MB, less than 60.66% of Java online submissions for Campus Bikes.
*/
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CampusBikes_1057 {
  public int[] assignBikes(int[][] workers, int[][] bikes) {
    Queue<int[]> pq =
        new PriorityQueue<>(
            (a, b) -> {
              int comp = Integer.compare(a[0], b[0]);
              if (comp == 0) {
                if (a[1] == b[1]) {
                  return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
              }

              return comp;
            });

    for (int w = 0; w < workers.length; w++) {
      for (int b = 0; b < bikes.length; b++) {
        int dist = Math.abs(workers[w][1] - bikes[b][1]) + Math.abs(workers[w][0] - bikes[b][0]);
        pq.add(new int[] {dist, w, b});
      }
    }

    int[] result = new int[workers.length];
    Arrays.fill(result, -1);

    boolean[] visitedBikes = new boolean[bikes.length];
    int size = 0;

    while (size < workers.length) {
      int[] curr = pq.remove();

      if (result[curr[1]] == -1 && !visitedBikes[curr[2]]) {
        result[curr[1]] = curr[2];
        visitedBikes[curr[2]] = true;
        size++;
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
