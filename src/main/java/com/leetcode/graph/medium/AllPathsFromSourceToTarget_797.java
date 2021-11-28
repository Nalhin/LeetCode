package com.leetcode.graph.medium;

// Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
// all possible paths from node 0 to node n - 1 and return them in any order.
//
// The graph is given as follows: graph[i] is a list of all nodes you can visit
// from node i (i.e., there is a directed edge from node i to node graph[i][j]).
//
//
// Example 1:
//
//
// Input: graph = [[1,2],[3],[3],[]]
// Output: [[0,1,3],[0,2,3]]
// Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
//
//
// Example 2:
//
//
// Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
// Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
//
//
// Example 3:
//
//
// Input: graph = [[1],[]]
// Output: [[0,1]]
//
//
// Example 4:
//
//
// Input: graph = [[1,2,3],[2],[3],[]]
// Output: [[0,1,2,3],[0,2,3],[0,3]]
//
//
// Example 5:
//
//
// Input: graph = [[1,3],[2],[3],[]]
// Output: [[0,1,2,3],[0,3]]
//
//
//
// Constraints:
//
//
// n == graph.length
// 2 <= n <= 15
// 0 <= graph[i][j] < n
// graph[i][j] != i (i.e., there will be no self-loops).
// All the elements of graph[i] are unique.
// The input graph is guaranteed to be a DAG.
//
// Related Topics Backtracking Depth-First Search Breadth-First Search Graph 👍
// 3100 👎 104
/*
 O(2^n * n) Runtime: 2 ms, faster than 95.58% of Java online submissions for All Paths From Source to Target.
 O(2^n * n) Memory Usage: 40.1 MB, less than 99.82% of Java online submissions for All Paths From Source to Target.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> result = new ArrayList<>();

    backtrack(graph, 0, new ArrayList<>(List.of(0)), result);

    return result;
  }

  private void backtrack(
      int[][] graph, int curr, List<Integer> currPath, List<List<Integer>> result) {
    if (curr == graph.length - 1) {
      result.add(new ArrayList<>(currPath));
      return;
    }

    for (int neighbour : graph[curr]) {
      currPath.add(neighbour);
      backtrack(graph, neighbour, currPath, result);
      currPath.remove(currPath.size() - 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
