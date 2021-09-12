package com.leetcode.graph.hard;

// You are given an undirected graph (the "original graph") with n nodes labeled
// from 0 to n - 1. You decide to subdivide each edge in the graph into a chain of
// nodes, with the number of new nodes varying between each edge.
//
// The graph is given as a 2D array of edges where edges[i] = [ui, vi, cnti]
// indicates that there is an edge between nodes ui and vi in the original graph, and
// cnti is the total number of new nodes that you will subdivide the edge into.
// Note that cnti == 0 means you will not subdivide the edge.
//
// To subdivide the edge [ui, vi], replace it with (cnti + 1) new edges and
// cnti new nodes. The new nodes are x1, x2, ..., xcnti, and the new edges are [ui, x1]
// , [x1, x2], [x2, x3], ..., [xcnti+1, xcnti], [xcnti, vi].
//
// In this new graph, you want to know how many nodes are reachable from the
// node 0, where a node is reachable if the distance is maxMoves or less.
//
// Given the original graph and maxMoves, return the number of nodes that are
// reachable from node 0 in the new graph.
//
//
// Example 1:
//
//
// Input: edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
// Output: 13
// Explanation: The edge subdivisions are shown in the image above.
// The nodes that are reachable are highlighted in yellow.
//
//
// Example 2:
//
//
// Input: edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
// Output: 23
//
//
// Example 3:
//
//
// Input: edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
//
// Output: 1
// Explanation: Node 0 is disconnected from the rest of the graph, so only node 0
// is reachable.
//
//
//
// Constraints:
//
//
// 0 <= edges.length <= min(n * (n - 1) / 2, 10⁴)
// edges[i].length == 3
// 0 <= ui < vi < n
// There are no multiple edges in the graph.
// 0 <= cnti <= 10⁴
// 0 <= maxMoves <= 10⁹
// 1 <= n <= 3000
//
/*
 O(E * log(V))Runtime: 93 ms, faster than 48.15% of Java online submissions for Reachable Nodes In Subdivided Graph.
 O(E) Memory Usage: 81 MB, less than 45.06% of Java online submissions for Reachable Nodes In Subdivided Graph.
*/
// Related Topics Graph Heap (Priority Queue) Shortest Path 👍 323 👎 183

import java.util.*;

// leetcode submit region begin(Prohibit modification and deletion)
public class ReachableNodesInSubdividedGraph_882 {
  public int reachableNodes(int[][] edges, int maxMoves, int n) {
    Map<Integer, List<Edge>> graph = new HashMap<>();

    for (int[] edge : edges) {
      int from = edge[0];
      int to = edge[1];
      int along = edge[2];

      graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new Edge(from, to, along));
      graph.computeIfAbsent(to, x -> new ArrayList<>()).add(new Edge(to, from, along));
    }

    Map<Integer, Integer> minDistances = new HashMap<>();
    Map<Integer, Integer> alongTraversed = new HashMap<>();
    minDistances.put(0, 0);

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
    pq.offer(new Node(0, 0));

    int result = 0;

    while (!pq.isEmpty()) {
      Node curr = pq.poll();
      int node = curr.node;

      if (curr.distance > minDistances.getOrDefault(node, Integer.MAX_VALUE)) {
        continue;
      }
      result++;

      if (!graph.containsKey(node)) {
        continue;
      }

      for (Edge neighbour : graph.get(node)) {

        int maxAllowed = Math.min(neighbour.along, maxMoves - curr.distance);
        alongTraversed.put(n * node + neighbour.to, maxAllowed);

        int newDist = curr.distance + neighbour.along + 1;
        if (newDist < minDistances.getOrDefault(neighbour.to, maxMoves + 1)) {
          pq.add(new Node(neighbour.to, newDist));
          minDistances.put(neighbour.to, newDist);
        }
      }
    }

    for (int[] edge : edges) {

      result +=
          Math.min(
              edge[2],
              alongTraversed.getOrDefault(edge[0] * n + edge[1], 0)
                  + alongTraversed.getOrDefault(edge[1] * n + edge[0], 0));
    }

    return result;
  }

  private static class Node {
    private final int node;
    private final int distance;

    private Node(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }

  private static class Edge {
    private final int from;
    private final int to;
    private final int along;

    private Edge(int from, int to, int along) {
      this.from = from;
      this.to = to;
      this.along = along;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
