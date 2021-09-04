package com.leetcode.graph.hard;

// There is an undirected connected tree with n nodes labeled from 0 to n - 1
// and n - 1 edges.
//
// You are given the integer n and the array edges where edges[i] = [ai, bi]
// indicates that there is an edge between nodes ai and bi in the tree.
//
// Return an array answer of length n where answer[i] is the sum of the
// distances between the iᵗʰ node in the tree and all other nodes.
//
//
// Example 1:
//
//
// Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
// Output: [8,12,6,10,10,10]
// Explanation: The tree is shown above.
// We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
// equals 1 + 1 + 2 + 2 + 2 = 8.
// Hence, answer[0] = 8, and so on.
//
//
// Example 2:
//
//
// Input: n = 1, edges = []
// Output: [0]
//
//
// Example 3:
//
//
// Input: n = 2, edges = [[1,0]]
// Output: [1,1]
//
//
//
// Constraints:
//
//
// 1 <= n <= 3 * 10⁴
// edges.length == n - 1
// edges[i].length == 2
// 0 <= ai, bi < n
// ai != bi
// The given input represents a valid tree.
//
/*
 O(V + E) Runtime: 69 ms, faster than 50.27% of Java online submissions for Sum of Distances in Tree.
 O(V + E) Memory Usage: 176.3 MB, less than 5.05% of Java online submissions for Sum of Distances in Tree.
*/
// Related Topics Dynamic Programming Tree Depth-First Search Graph 👍 1776 👎 5
// 4

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)
public class SumOfDistancesInTree_834 {
  public int[] sumOfDistancesInTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    int[] childCount = new int[n];
    countChildren(0, -1, graph, childCount);

    int[] result = new int[n];
    result[0] = totalDistance(0, -1, 0, graph);
    for (int node : graph.get(0)) {
      deriveDistanceFromParent(node, 0, n, childCount, result, graph);
    }

    return result;
  }

  private void deriveDistanceFromParent(
      int curr, int parent, int n, int[] nodes, int[] result, Map<Integer, List<Integer>> graph) {
    int children = nodes[curr];
    int nodesAfter = n - children;

    int currDist = result[parent] + nodesAfter - children;
    result[curr] = currDist;

    for (int neighbour : graph.get(curr)) {
      if (neighbour == parent) {
        continue;
      }
      deriveDistanceFromParent(neighbour, curr, n, nodes, result, graph);
    }
  }

  private int countChildren(int curr, int parent, Map<Integer, List<Integer>> graph, int[] nodes) {
    int children = 1;

    for (int neighbour : graph.get(curr)) {
      if (neighbour == parent) {
        continue;
      }
      children += countChildren(neighbour, curr, graph, nodes);
    }

    nodes[curr] = children;

    return children;
  }

  private int totalDistance(int curr, int parent, int dist, Map<Integer, List<Integer>> graph) {
    int sum = dist;

    for (int neighbour : graph.get(curr)) {
      if (neighbour == parent) {
        continue;
      }
      sum += totalDistance(neighbour, curr, dist + 1, graph);
    }

    return sum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
