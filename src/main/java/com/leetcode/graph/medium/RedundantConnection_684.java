package com.leetcode.graph.medium;

// In this problem, a tree is an undirected graph that is connected and has no cy
// cles.
//
// You are given a graph that started as a tree with n nodes labeled from 1 to n
// , with one additional edge added. The added edge has two different vertices chos
// en from 1 to n, and was not an edge that already existed. The graph is represent
// ed as an array edges of length n where edges[i] = [ai, bi] indicates that there
// is an edge between nodes ai and bi in the graph.
//
// Return an edge that can be removed so that the resulting graph is a tree of n
// nodes. If there are multiple answers, return the answer that occurs last in the
// input.
//
//
// Example 1:
//
//
// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]
//
//
// Example 2:
//
//
// Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
// Output: [1,4]
//
//
//
// Constraints:
//
//
// n == edges.length
// 3 <= n <= 1000
// edges[i].length == 2
// 1 <= ai < bi <= edges.length
// ai != bi
// There are no repeated edges.
// The given graph is connected.
//
// Related Topics Depth-First Search Breadth-First Search Union Find Graph
// 👍 2343 👎 261
/*
 O(n^2) Runtime: 4 ms, faster than 24.99% of Java online submissions for Redundant Connection.
 O(n) Memory Usage: 40.1 MB, less than 16.46% of Java online submissions for Redundant Connection.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection_684 {
  public int[] findRedundantConnection(int[][] edges) {
    int n = edges.length;

    List<List<Integer>> graph = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
      int from = edge[0] - 1;
      int to = edge[1] - 1;

      if (isConnected(from, to, graph, new boolean[n])) {
        return edge;
      }

      graph.get(from).add(to);
      graph.get(to).add(from);
    }

    throw new IllegalArgumentException();
  }

  private boolean isConnected(int from, int to, List<List<Integer>> graph, boolean[] visited) {

    if (from == to) {
      return true;
    }

    for (int edge : graph.get(from)) {
      if (!visited[edge]) {
        visited[edge] = true;
        if (isConnected(edge, to, graph, visited)) {
          return true;
        }
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
