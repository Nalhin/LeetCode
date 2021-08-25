package com.leetcode.graph.medium;

/*
Runtime: 5 ms, faster than 70.37% of Java online submissions for All Paths from Source Lead to Destination.
Memory Usage: 41 MB, less than 92.25% of Java online submissions for All Paths from Source Lead to Destination.

 */
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree_261 {
  public boolean validTree(int n, int[][] edges) {
    boolean[] visited = new boolean[n];

    Map<Integer, List<Integer>> graph = new HashMap<>();
    for(int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
    }

    for(int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    if(!isTreeDfs(0, -1, graph, visited)){
      return false;
    }


    for(boolean node : visited){
      if(!node){
        return false;
      }
    }

    return true;
  }


  private boolean isTreeDfs(int curr, int prev, Map<Integer, List<Integer>> graph, boolean[] visited){
    if(visited[curr]){
      return false;
    }

    visited[curr] = true;
    List<Integer> children = graph.get(curr);
    for(int child : children){
      if(child == curr || child == prev){
        continue;
      }
      if(!isTreeDfs(child, curr, graph, visited)){
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
