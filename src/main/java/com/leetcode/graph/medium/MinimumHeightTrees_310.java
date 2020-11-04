package com.leetcode.graph.medium;

// A tree is an undirected graph in which any two vertices are connected by exact
// ly one path. In other words, any connected graph without simple cycles is a tree
// .
//
// Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges
// where edges[i] = [ai, bi] indicates that there is an undirected edge between th
// e two nodes ai and bi in the tree, you can choose any node of the tree as the ro
// ot. When you select a node x as the root, the result tree has height h. Among al
// l possible rooted trees, those with minimum height (i.e. min(h)) are called mini
// mum height trees (MHTs).
//
// Return a list of all MHTs' root labels. You can return the answer in any orde
// r.
//
// The height of a rooted tree is the number of edges on the longest downward pa
// th between the root and a leaf.
//
//
// Example 1:
//
//
// Input: n = 4, edges = [[1,0],[1,2],[1,3]]
// Output: [1]
// Explanation: As shown, the height of the tree is 1 when the root is the node w
// ith label 1 which is the only MHT.
//
//
// Example 2:
//
//
// Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
// Output: [3,4]
//
//
// Example 3:
//
//
// Input: n = 1, edges = []
// Output: [0]
//
//
// Example 4:
//
//
// Input: n = 2, edges = [[0,1]]
// Output: [0,1]
//
//
//
// Constraints:
//
//
// 1 <= n <= 2 * 104
// edges.length == n - 1
// 0 <= ai, bi < n
// ai != bi
// All the pairs (ai, bi) are distinct.
// The given input is guaranteed to be a tree and there will be no repeated edge
// s.
//
// Related Topics Breadth-first Search Graph
// 👍 2440 👎 116

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
 O(V) Runtime: 10 ms, faster than 89.89% of Java online submissions for Minimum Height Trees.
 O(V) Memory Usage: 42.8 MB, less than 5.63% of Java online submissions for Minimum Height Trees.
*/
public class MinimumHeightTrees_310 {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();
    if (n == 1) {
      return List.of(0);
    }

    int[] degree = new int[n];
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
      degree[edge[0]]++;
      degree[edge[1]]++;
    }
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      if (degree[i] == 1) {
        queue.offer(i);
      }
    }
    List<Integer> res = new ArrayList<>();

    while (!queue.isEmpty()) {
      res.clear();
      int count = queue.size();
      for (int i = 0; i < count; i++) {
        int curr = queue.remove();
        res.add(curr);
        for (int next : graph.get(curr)) {
          if (degree[next] == 2) {
            queue.offer(next);
          }
          degree[next]--;
        }
      }
    }
    return res;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
