package com.leetcode.graph.easy;

//There is a bi-directional graph with n vertices, where each vertex is labeled
//from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D
//integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge
//between vertex ui and vertex vi. Every vertex pair is connected by at most one
//edge, and no vertex has an edge to itself.
//
// You want to determine if there is a valid path that exists from vertex
//source to vertex destination.
//
// Given edges and the integers n, source, and destination, return true if
//there is a valid path from source to destination, or false otherwise.
//
//
// Example 1:
//
//
//Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
//Output: true
//Explanation: There are two paths from vertex 0 to vertex 2:
//- 0 → 1 → 2
//- 0 → 2
//
//
// Example 2:
//
//
//Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0,
//destination = 5
//Output: false
//Explanation: There is no path from vertex 0 to vertex 5.
//
//
//
// Constraints:
//
//
// 1 <= n <= 2 * 10⁵
// 0 <= edges.length <= 2 * 10⁵
// edges[i].length == 2
// 0 <= ui, vi <= n - 1
// ui != vi
// 0 <= source, destination <= n - 1
// There are no duplicate edges.
// There are no self edges.
//
//
// Related Topics Depth-First Search Breadth-First Search Union Find Graph 👍 24
//43 👎 127
/*
  O(alfa(V) * E) Runtime: 16 ms, faster than 96.83% of Java online submissions for Find if Path Exists in Graph.
  O(V) Memory Usage: 139 MB, less than 78.81% of Java online submissions for Find if Path Exists in Graph.
*/

//leetcode submit region begin(Prohibit modification and deletion)

public class FindIfPathExistsInAGraph_1971 {
  public boolean validPath(int n, int[][] edges, int source, int destination) {

    UnionFind uf = new UnionFind(n);

    for(int[] edge : edges) {

      uf.connect(edge[0], edge[1]);

      if(uf.isConnected(source, destination)) {
        return true;
      }
    }

    return source == destination;
  }


  private static class UnionFind {

    private final int[] parents;
    private final int[] ranks;

    private UnionFind(int n) {
      this.parents = new int[n];
      this.ranks = new int[n];
      for(int i = 0; i < n; i++) {
        parents[i] = i;
      }
    }


    private int parent(int node) {
      if(parents[node] != node) {
        return parents[node] = parent(parents[node]);
      }
      return node;
    }


    private boolean isConnected(int n1, int n2) {
      return parent(n1) == parent(n2);
    }


    private void connect(int n1, int n2) {

      int p1 = parent(n1);
      int p2 = parent(n2);


      if (p1 == p2) {
        return;
      }

      if(ranks[p1] > ranks[p2]) {
        ranks[p2]++;
        parents[p2] = p1;
      } else if (ranks[p1] < ranks[p2]) {
        ranks[p1]++;
        parents[p1] = p2;
      } else {
        ranks[p1]++;
        parents[p1] = p2;
      }
    }
  }
}
//leetcode submit region end(Prohibit modification and deletion)
