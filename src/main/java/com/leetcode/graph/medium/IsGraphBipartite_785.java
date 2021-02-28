package com.leetcode.graph.medium;

// There is an undirected graph with n nodes, where each node is numbered between
// 0 and n - 1. You are given a 2D array graph, where graph[u] is an array of node
// s that node u is adjacent to. More formally, for each v in graph[u], there is an
// undirected edge between node u and node v. The graph has the following properti
// es:
//
//
// There are no self-edges (graph[u] does not contain u).
// There are no parallel edges (graph[u] does not contain duplicate values).
// If v is in graph[u], then u is in graph[v] (the graph is undirected).
// The graph may not be connected, meaning there may be two nodes u and v such t
// hat there is no path between them.
//
//
// A graph is bipartite if the nodes can be partitioned into two independent set
// s A and B such that every edge in the graph connects a node in set A and a node
// in set B.
//
// Return true if and only if it is bipartite.
//
//
// Example 1:
//
//
// Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
// Output: false
// Explanation: There is no way to partition the nodes into two independent sets
// such that every edge connects a node in one and a node in the other.
//
// Example 2:
//
//
// Input: graph = [[1,3],[0,2],[1,3],[0,2]]
// Output: true
// Explanation: We can partition the nodes into two sets: {0, 2} and {1, 3}.
//
//
// Constraints:
//
//
// graph.length == n
// 1 <= n <= 100
// 0 <= graph[u].length < n
// 0 <= graph[u][i] <= n - 1
// graph[u] does not contain u.
// All the values of graph[u] are unique.
// If graph[u] contains v, then graph[v] contains u.
//
// Related Topics Depth-first Search Breadth-first Search Graph
// 👍 2396 👎 217

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(n) Runtime: 2 ms, faster than 31.11% of Java online submissions for Is Graph Bipartite?.
 O(n) Memory Usage: 39.4 MB, less than 63.68% of Java online submissions for Is Graph Bipartite?.
*/
public class IsGraphBipartite_785 {
  public boolean isBipartite(int[][] graph) {
    int[] colors = new int[graph.length];
    Arrays.fill(colors, -1);

    for (int i = 0; i < graph.length; i++) {
      if (colors[i] != -1) {
        continue;
      }

      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(i);
      colors[i] = 0;

      while (!stack.isEmpty()) {
        int curr = stack.pop();

        for (int neighbor : graph[curr]) {
          int expectedColor = (colors[curr] + 1) % 2;
          if (colors[neighbor] != -1 && colors[neighbor] != expectedColor) {
            return false;
          }
          if (colors[neighbor] == -1) {
            colors[neighbor] = expectedColor;
            stack.push(neighbor);
          }
        }
      }
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
