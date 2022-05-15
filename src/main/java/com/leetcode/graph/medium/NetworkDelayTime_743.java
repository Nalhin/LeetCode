package com.leetcode.graph.medium;

// You are given a network of n nodes, labeled from 1 to n. You are also given
// times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui
// is the source node, vi is the target node, and wi is the time it takes for a
// signal to travel from source to target.
//
// We will send a signal from a given node k. Return the time it takes for all
// the n nodes to receive the signal. If it is impossible for all the n nodes to
// receive the signal, return -1.
//
//
// Example 1:
//
//
// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
// Output: 2
//
//
// Example 2:
//
//
// Input: times = [[1,2,1]], n = 2, k = 1
// Output: 1
//
//
// Example 3:
//
//
// Input: times = [[1,2,1]], n = 2, k = 2
// Output: -1
//
//
//
// Constraints:
//
//
// 1 <= k <= n <= 100
// 1 <= times.length <= 6000
// times[i].length == 3
// 1 <= ui, vi <= n
// ui != vi
// 0 <= wi <= 100
// All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
//
// Related Topics Depth-First Search Breadth-First Search Graph Heap (Priority
// Queue) Shortest Path 👍 4785 👎 305
/*
  O(Elog(E))Runtime: 26 ms, faster than 51.92% of Java online submissions for Network Delay Time.
  O(V + E) Memory Usage: 65.9 MB, less than 36.87% of Java online submissions for Network Delay Time.
 */
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class NetworkDelayTime_743 {
  public int networkDelayTime(int[][] times, int n, int k) {

    Map<Integer, List<Edge>> graph = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int[] edge : times) {
      graph.get(edge[0]).add(new Edge(edge[0], edge[1], edge[2]));
    }

    PriorityQueue<VertexResult> pq =
        new PriorityQueue<>(Comparator.comparingInt(v -> v.totalDistance));
    Map<Integer, Integer> distances = new HashMap<>();
    pq.add(new VertexResult(k, 0));
    distances.put(k, 0);

    Set<Integer> visited = new HashSet<>();
    visited.add(k);

    while (!pq.isEmpty()) {
      VertexResult current = pq.remove();

      if (distances.getOrDefault(current.vertex, Integer.MAX_VALUE) < current.totalDistance) {
        continue;
      }

      visited.add(current.vertex);
      if (visited.size() == n) {
        return current.totalDistance;
      }

      for (Edge edge : graph.get(current.vertex)) {
        int newDist = current.totalDistance + edge.weight;
        if (distances.getOrDefault(edge.to, Integer.MAX_VALUE) > newDist) {
          pq.add(new VertexResult(edge.to, newDist));
          distances.put(edge.to, newDist);
        }
      }
    }

    return -1;
  }

  private static class Edge {
    final int from;
    final int to;
    final int weight;

    private Edge(int from, int to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }
  }

  private static class VertexResult {
    final int vertex;
    final int totalDistance;

    private VertexResult(int vertex, int totalDistance) {
      this.vertex = vertex;
      this.totalDistance = totalDistance;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
