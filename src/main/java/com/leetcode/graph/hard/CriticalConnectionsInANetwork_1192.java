package com.leetcode.graph.hard;

// There are n servers numbered from 0 to n-1 connected by undirected server-to-s
// erver connections forming a network where connections[i] = [a, b] represents a c
// onnection between servers a and b. Any server can reach any other server directl
// y or indirectly through the network.
//
// A critical connection is a connection that, if removed, will make some server
// unable to reach some other server.
//
// Return all critical connections in the network in any order.
//
//
// Example 1:
//
//
//
//
// Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
// Output: [[1,3]]
// Explanation: [[3,1]] is also accepted.
//
//
//
// Constraints:
//
//
// 1 <= n <= 10^5
// n-1 <= connections.length <= 10^5
// connections[i][0] != connections[i][1]
// There are no repeated connections.
//
// Related Topics Depth-first Search
// 👍 2247 👎 114
/*
 O(V + E) Runtime: 325 ms, faster than 8.93% of Java online submissions for Critical Connections in a Network.
 O(V + E) Memory Usage: 120.2 MB, less than 43.70% of Java online submissions for Critical Connections in a Network.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
import java.util.stream.Collectors;

public class CriticalConnectionsInANetwork_1192 {
  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (List<Integer> conn : connections) {
      graph.get(conn.get(0)).add(conn.get(1));
      graph.get(conn.get(1)).add(conn.get(0));
    }

    int[] ranks = new int[n];
    Arrays.fill(ranks, -2);
    Set<List<Integer>> sortedConnections =
        connections.stream()
            .map(list -> list.stream().sorted().collect(Collectors.toList()))
            .collect(Collectors.toSet());

    for (int i = 0; i < n; i++) {
      dfs(0, i, ranks, graph, sortedConnections);
    }

    return new ArrayList<>(sortedConnections);
  }

  private int dfs(
      int curr,
      int depth,
      int[] ranks,
      Map<Integer, List<Integer>> graph,
      Set<List<Integer>> connections) {
    if (ranks[curr] >= 0) {
      return ranks[curr];
    }
    ranks[curr] = depth;

    int minDepth = depth;
    for (int neighbour : graph.get(curr)) {
      if (ranks[neighbour] == depth - 1) {
        continue;
      }

      int neighbourDepth = dfs(neighbour, depth + 1, ranks, graph, connections);
      if (neighbourDepth <= depth) {
        connections.remove(List.of(Math.min(curr, neighbour), Math.max(neighbour, curr)));
      }
      minDepth = Math.min(minDepth, neighbourDepth);
    }

    return minDepth;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
