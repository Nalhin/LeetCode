package com.leetcode.graph.medium;

// You are given an array points representing integer coordinates of some points
// on a 2D-plane, where points[i] = [xi, yi].
//
// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan
// distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute
// value of val.
//
// Return the minimum cost to make all points connected. All points are
// connected if there is exactly one simple path between any two points.
//
//
// Example 1:
//
//
// Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
// Output: 20
// Explanation:
//
// We can connect the points as shown above to get the minimum cost of 20.
// Notice that there is a unique path between every pair of points.
//
//
// Example 2:
//
//
// Input: points = [[3,12],[-2,5],[-4,1]]
// Output: 18
//
//
//
// Constraints:
//
//
// 1 <= points.length <= 1000
// -10⁶ <= xi, yi <= 10⁶
// All pairs (xi, yi) are distinct.
//
// Related Topics Array Union Find Minimum Spanning Tree 👍 2338 👎 71
/*
 O(n^2 * log(n)) Runtime: 694 ms, faster than 22.82% of Java online submissions for Min Cost to Connect All Points.
 O(n^2) Memory Usage: 113.5 MB, less than 39.75% of Java online submissions for Min Cost to Connect All Points.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// leetcode submit region end(Prohibit modification and deletion)
public class MinCostToConnectAllPoints_1584 {
  public int minCostConnectPoints(int[][] points) {
    Dsu dsu = new Dsu(points.length);

    List<Connection> connections = new ArrayList<>();

    for (int first = 0; first < points.length; first++) {
      for (int second = first + 1; second < points.length; second++) {
        int[] firstPoint = points[first];
        int[] secondPoint = points[second];

        connections.add(
            new Connection(
                Math.abs(firstPoint[0] - secondPoint[0]) + Math.abs(firstPoint[1] - secondPoint[1]),
                first,
                second));
      }
    }

    connections.sort(Comparator.comparingInt(p -> p.distance));

    int result = 0;

    for (Connection c : connections) {
      if (!dsu.isConnected(c.from, c.to)) {
        result += c.distance;
        dsu.connect(c.from, c.to);
      }
    }

    return result;
  }

  private static class Connection {
    int distance;
    int from;
    int to;

    Connection(int distance, int from, int to) {
      this.distance = distance;
      this.from = from;
      this.to = to;
    }
  }

  private static class Dsu {
    private final int[] parent;
    private final int[] rank;

    Dsu(int len) {
      parent = new int[len];
      for (int i = 0; i < len; i++) {
        parent[i] = i;
      }
      rank = new int[len];
    }

    public int parent(int node) {
      if (parent[node] == node) {
        return node;
      }
      return parent[node] = parent(parent[node]);
    }

    public boolean isConnected(int first, int second) {
      return parent(first) == parent(second);
    }

    public void connect(int first, int second) {
      int firstParent = parent(first);
      int secondParent = parent(second);

      if (firstParent == secondParent) {
        return;
      }

      int rankFirst = rank[firstParent];
      int rankSecond = rank[secondParent];

      if (rankFirst > rankSecond) {
        parent[secondParent] = firstParent;
      } else if (rankFirst < rankSecond) {
        parent[firstParent] = secondParent;
      } else {
        parent[firstParent] = secondParent;
        rank[secondParent]++;
      }
    }
  }
}
