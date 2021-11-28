package com.leetcode.graph.medium;

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree_261 {

  /*
   O(n) Runtime: 5 ms, faster than 70.37% of Java online submissions for All Paths from Source Lead to Destination.
   O(n) Memory Usage: 41 MB, less than 92.25% of Java online submissions for All Paths from Source Lead to Destination.
  */
  static class Dfs {
    public boolean validTree(int n, int[][] edges) {
      boolean[] visited = new boolean[n];

      Map<Integer, List<Integer>> graph = new HashMap<>();
      for (int i = 0; i < n; i++) {
        graph.put(i, new ArrayList<>());
      }

      for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
      }

      if (!isTreeDfs(0, -1, graph, visited)) {
        return false;
      }

      for (boolean node : visited) {
        if (!node) {
          return false;
        }
      }

      return true;
    }

    private boolean isTreeDfs(
        int curr, int prev, Map<Integer, List<Integer>> graph, boolean[] visited) {
      if (visited[curr]) {
        return false;
      }

      visited[curr] = true;
      List<Integer> children = graph.get(curr);
      for (int child : children) {
        if (child == curr || child == prev) {
          continue;
        }
        if (!isTreeDfs(child, curr, graph, visited)) {
          return false;
        }
      }

      return true;
    }
  }

  static class Dsu {
    public boolean validTree(int n, int[][] edges) {

      UnionFind uf = new UnionFind(n);

      for (int[] edge : edges) {
        if (uf.isConnected(edge[0], edge[1])) {
          return false;
        }
        uf.union(edge[0], edge[1]);
      }

      return uf.sets == 1;
    }
    /*
     O(n * a(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Graph Valid Tree.
     O(n) Memory Usage: 40 MB, less than 51.88% of Java online submissions for Graph Valid Tree.
    */
    private static class UnionFind {
      private final int[] root;
      private final int[] rank;
      private int sets;

      private UnionFind(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        this.sets = n;

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

      private void union(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);

        if (rootA == rootB) {
          return;
        }

        if (rank[rootA] == rank[rootB]) {
          root[rootB] = rootA;
          rank[rootA]++;
        } else if (rank[rootA] > rank[rootB]) {
          root[rootB] = rootA;
        } else {
          root[rootA] = rootB;
        }
        sets--;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
