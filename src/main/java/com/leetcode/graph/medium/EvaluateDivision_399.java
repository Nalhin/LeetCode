package com.leetcode.graph.medium;

// You are given an array of variable pairs equations and an array of real
// numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai
/// Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
//
// You are also given some queries, where queries[j] = [Cj, Dj] represents the
// jᵗʰ query where you must find the answer for Cj / Dj = ?.
//
// Return the answers to all queries. If a single answer cannot be determined,
// return -1.0.
//
// Note: The input is always valid. You may assume that evaluating the queries
// will not result in division by zero and that there is no contradiction.
//
//
// Example 1:
//
//
// Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a",
// "c"],["b","a"],["a","e"],["a","a"],["x","x"]]
// Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
// Explanation:
// Given: a / b = 2.0, b / c = 3.0
// queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
// return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
//
//
// Example 2:
//
//
// Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
// queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
// Output: [3.75000,0.40000,5.00000,0.20000]
//
//
// Example 3:
//
//
// Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"]
// ,["a","c"],["x","y"]]
// Output: [0.50000,2.00000,-1.00000,-1.00000]
//
//
//
// Constraints:
//
//
// 1 <= equations.length <= 20
// equations[i].length == 2
// 1 <= Ai.length, Bi.length <= 5
// values.length == equations.length
// 0.0 < values[i] <= 20.0
// 1 <= queries.length <= 20
// queries[i].length == 2
// 1 <= Cj.length, Dj.length <= 5
// Ai, Bi, Cj, Dj consist of lower case English letters and digits.
//
// Related Topics Array Depth-First Search Breadth-First Search Union Find
// Graph Shortest Path 👍 5427 👎 458
/*
 O(n * m) Runtime: 2 ms, faster than 55.02% of Java online submissions for Evaluate Division.
 O(n) Memory Usage: 42.5 MB, less than 57.96% of Java online submissions for Evaluate Division.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class EvaluateDivision_399 {
  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {

    Map<String, List<Edge>> graph = new HashMap<>();

    for (int i = 0; i < equations.size(); i++) {
      List<String> eq = equations.get(i);

      graph
          .computeIfAbsent(eq.get(0), (ing) -> new ArrayList<>())
          .add(new Edge(eq.get(1), values[i]));
      graph
          .computeIfAbsent(eq.get(1), (ing) -> new ArrayList<>())
          .add(new Edge(eq.get(0), 1 / values[i]));
    }

    double[] result = new double[queries.size()];

    for (int i = 0; i < result.length; i++) {
      List<String> query = queries.get(i);

      result[i] = dfs(graph, query.get(0), query.get(1), new HashSet<>());
    }

    return result;
  }

  private double dfs(
      Map<String, List<Edge>> graph, String current, String target, Set<String> visited) {
    if (visited.contains(current)) {
      return -1;
    }
    if (!graph.containsKey(current)) {
      return -1;
    }

    if (current.equals(target)) {
      return 1;
    }

    visited.add(current);

    for (Edge e : graph.get(current)) {

      if (e.to.equals(target)) {
        return e.value;
      }

      double res = dfs(graph, e.to, target, visited);

      if (res != -1) {
        return res * e.value;
      }
    }

    visited.remove(current);

    return -1;
  }

  private static class Edge {
    String to;
    double value;

    Edge(String to, double value) {
      this.to = to;
      this.value = value;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
