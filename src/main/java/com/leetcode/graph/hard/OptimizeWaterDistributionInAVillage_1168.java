package com.leetcode.graph.hard;

// There are n houses in a village. We want to supply water for all the houses by
// building wells and laying pipes.
//
// For each house i, we can either build a well inside it directly with cost wel
// ls[i - 1] (note the -1 due to 0-indexing), or pipe in water from another well to
// it. The costs to lay pipes between houses are given by the array pipes, where e
// ach pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j
// and house2j together using a pipe. Connections are bidirectional.
//
// Return the minimum total cost to supply water to all houses.
//
//
// Example 1:
//
//
//
//
// Input: n = 3, wells = [1,2,2], pipes = [[1,2,1],[2,3,1]]
// Output: 3
// Explanation:
// The image shows the costs of connecting houses using pipes.
// The best strategy is to build a well in the first house with cost 1 and connec
// t the other houses to it with cost 2 so the total cost is 3.
//
//
//
// Constraints:
//
//
// 1 <= n <= 104
// wells.length == n
// 0 <= wells[i] <= 105
// 1 <= pipes.length <= 104
// pipes[j].length == 3
// 1 <= house1j, house2j <= n
// 0 <= costj <= 105
// house1j != house2j
//

// Related Topics Union Find Graph Minimum Spanning Tree
// 👍 503 👎 19

import java.util.*;

// leetcode submit region begin(Prohibit modification and deletion)
public class OptimizeWaterDistributionInAVillage_1168 {

  /*
    O((n + m) * log(n + m))Runtime: 35 ms, faster than 50.66% of Java online submissions for Optimize Water Distribution in a Village.
    O(n + m) Memory Usage: 46.9 MB, less than 34.38% of Java online submissions for Optimize Water Distribution in a Village.
  */
  static class Prim {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
      Map<Integer, List<Pipe>> graph = new HashMap<>();
      boolean[] filled = new boolean[n + 1];

      for (int i = 0; i <= n; ++i) {
        graph.put(i, new ArrayList<>());
      }

      for (int i = 1; i <= n; i++) {
        graph.get(0).add(new Pipe(wells[i - 1], i));
      }

      for (int[] pipe : pipes) {
        graph.get(pipe[0]).add(new Pipe(pipe[2], pipe[1]));
        graph.get(pipe[1]).add(new Pipe(pipe[2], pipe[0]));
      }

      int result = 0;
      Queue<Pipe> pq = new PriorityQueue<>();
      pq.add(new Pipe(0, 0));

      while (!pq.isEmpty()) {
        Pipe curr = pq.poll();

        if (filled[curr.connectsTo]) {
          continue;
        }

        filled[curr.connectsTo] = true;
        result += curr.val;

        for (Pipe pipe : graph.get(curr.connectsTo)) {
          if (!filled[pipe.connectsTo]) {
            pq.add(pipe);
          }
        }
      }

      return result;
    }

    private static class Pipe implements Comparable<Pipe> {

      private final int val;
      private final int connectsTo;

      private Pipe(int val, int connectsTo) {
        this.val = val;
        this.connectsTo = connectsTo;
      }

      @Override
      public int compareTo(Pipe o) {
        return Integer.compare(val, o.val);
      }
    }
  }

  /*
    Runtime: 27 ms, faster than 62.12% of Java online submissions for Optimize Water Distribution in a Village.
    Memory Usage: 45.3 MB, less than 65.51% of Java online submissions for Optimize Water Distribution in a Village.
  */
  static class Kruskal {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
      List<Pipe> pipeList = new ArrayList<>();
      for (int i = 1; i <= n; i++) {
        pipeList.add(new Pipe(0, i, wells[i - 1]));
      }
      for (int[] pipe : pipes) {
        pipeList.add(new Pipe(pipe[0], pipe[1], pipe[2]));
      }

      pipeList.sort(Comparator.comparingInt(p -> p.cost));

      DisjointSet dsu = new DisjointSet(n + 1);
      int result = 0;

      for (Pipe pipe : pipeList) {
        if (!dsu.isConnected(pipe.from, pipe.to)) {
          dsu.connect(pipe.from, pipe.to);
          result += pipe.cost;
        }
      }

      return result;
    }

    static class Pipe {
      int from;
      int to;
      int cost;

      private Pipe(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
      }
    }

    static class DisjointSet {
      private final int[] root;
      private final int[] rank;

      private DisjointSet(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
          root[i] = i;
        }
      }

      private boolean isConnected(int a, int b) {
        return root(a) == root(b);
      }

      private int root(int a) {
        if (root[a] == a) {
          return a;
        }
        return root[a] = root(root[a]);
      }

      private void connect(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rank[rootA] == rank[rootB]) {
          root[rootB] = rootA;
          rank[rootA]++;
        } else if (rank[rootA] > rank[rootB]) {
          root[rootB] = rootA;
        } else {
          root[rootA] = rootB;
        }
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
