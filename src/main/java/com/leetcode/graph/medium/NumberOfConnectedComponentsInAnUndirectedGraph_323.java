package com.leetcode.graph.medium;

// You have a graph of n nodes. You are given an integer n and an array edges whe
// re edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the
// graph.
//
// Return the number of connected components in the graph.
//
//
// Example 1:
//
//
// Input: n = 5, edges = [[0,1],[1,2],[3,4]]
// Output: 2
//
//
// Example 2:
//
//
// Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= n <= 2000
// 1 <= edges.length <= 5000
// edges[i].length == 2
// 0 <= ai <= bi < n
// ai != bi
// There are no repeated edges.
//
// Related Topics Depth-first Search Breadth-first Search Union Find Graph
// 👍 1212 👎 36

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
  /*
   O(E + V) Runtime: 5 ms, faster than 43.84% of Java online submissions for Number of Connected Components in an Undirected Graph.
   O(E + V) Memory Usage: 39.8 MB, less than 36.90% of Java online submissions for Number of Connected Components in an Undirected Graph.
  */
  static class Dfs {
    public int countComponents(int n, int[][] edges) {
      Map<Integer, List<Integer>> graph = new HashMap<>();

      for (int i = 0; i < n; i++) {
        graph.put(i, new ArrayList<>());
      }

      for (int[] edge : edges) {
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
      }

      boolean[] visited = new boolean[n];
      int result = 0;
      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          visitDfs(i, graph, visited);
          result++;
        }
      }
      return result;
    }

    private void visitDfs(int curr, Map<Integer, List<Integer>> graph, boolean[] visited) {
      if (visited[curr]) {
        return;
      }
      visited[curr] = true;
      for (int neighbour : graph.get(curr)) {
        visitDfs(neighbour, graph, visited);
      }
    }
  }

  /*
    O(E * a(V) + V) Runtime: 1 ms, faster than 100.00% of Java online submissions for Number of Connected Components in an Undirected Graph.
    O(V) Memory Usage: 39.6 MB, less than 86.42% of Java online submissions for Number of Connected Components in an Undirected Graph.
  */
  static class Dsu {
    public int countComponents(int n, int[][] edges) {
      DisjointSet dsu = new DisjointSet(n);

      for (int[] edge : edges) {
        dsu.connect(edge[0], edge[1]);
      }

      return dsu.components;
    }

    private static class DisjointSet {
      private final int[] rank;
      private final int[] root;
      private int components;

      private DisjointSet(int n) {
        this.rank = new int[n];
        this.root = new int[n];
        this.components = n;

        for (int i = 0; i < n; i++) {
          root[i] = i;
        }
      }

      private void connect(int a, int b) {
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
        components--;
      }

      private int root(int a) {
        if (root[a] == a) {
          return a;
        }
        return root[a] = root(root[a]);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
