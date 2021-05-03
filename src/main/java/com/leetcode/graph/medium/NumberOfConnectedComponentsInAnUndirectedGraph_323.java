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
/*
 O(E + V) Runtime: 5 ms, faster than 43.84% of Java online submissions for Number of Connected Components in an Undirected Graph.
 O(E + V) Memory Usage: 39.8 MB, less than 36.90% of Java online submissions for Number of Connected Components in an Undirected Graph.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
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
// leetcode submit region end(Prohibit modification and deletion)
