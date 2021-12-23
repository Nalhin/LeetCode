package com.leetcode.graph.medium;

// There are a total of numCourses courses you have to take, labeled from 0 to
// numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai,
// bi] indicates that you must take course bi first if you want to take course ai.
//
//
//
// For example, the pair [0, 1], indicates that to take course 0 you have to
// first take course 1.
//
//
// Return the ordering of courses you should take to finish all courses. If
// there are many valid answers, return any of them. If it is impossible to finish all
// courses, return an empty array.
//
//
// Example 1:
//
//
// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you
// should have finished course 0. So the correct course order is [0,1].
//
//
// Example 2:
//
//
// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]
// Explanation: There are a total of 4 courses to take. To take course 3 you
// should have finished both courses 1 and 2. Both courses 1 and 2 should be taken
// after you finished course 0.
// So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3
// ].
//
//
// Example 3:
//
//
// Input: numCourses = 1, prerequisites = []
// Output: [0]
//
//
//
// Constraints:
//
//
// 1 <= numCourses <= 2000
// 0 <= prerequisites.length <= numCourses * (numCourses - 1)
// prerequisites[i].length == 2
// 0 <= ai, bi < numCourses
// ai != bi
// All the pairs [ai, bi] are distinct.
//
// Related Topics Depth-First Search Breadth-First Search Graph Topological
// Sort 👍 5527 👎 213

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class CourseScheduleII_210 {
  /*
   O(V + E) Runtime: 5 ms, faster than 73.45% of Java online submissions for Course Schedule II.
   O(V + E) Memory Usage: 40.3 MB, less than 46.47% of Java online submissions for Course Schedule II.
  */
  static class Dfs {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

      Map<Integer, List<Integer>> graph = new HashMap<>();

      for (int i = 0; i < numCourses; i++) {
        graph.put(i, new ArrayList<>());
      }

      for (int[] prerequisite : prerequisites) {
        graph.get(prerequisite[0]).add(prerequisite[1]);
      }

      List<Integer> result = new ArrayList<>();
      boolean[] visited = new boolean[numCourses];
      boolean[] visiting = new boolean[numCourses];

      for (int i = 0; i < numCourses; i++) {
        if (!dfs(i, result, graph, visited, visiting)) {
          return new int[0];
        }
      }

      return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean dfs(
        int curr,
        List<Integer> result,
        Map<Integer, List<Integer>> graph,
        boolean[] visited,
        boolean[] visiting) {

      if (visiting[curr]) {
        return false;
      }

      if (visited[curr]) {
        return true;
      }

      visiting[curr] = true;

      for (Integer prerequisite : graph.get(curr)) {
        if (!dfs(prerequisite, result, graph, visited, visiting)) {
          return false;
        }
      }

      visiting[curr] = false;

      visited[curr] = true;

      result.add(curr);

      return true;
    }
  }

  /*
   O(V + E) Runtime: 8 ms, faster than 39.16% of Java online submissions for Course Schedule II.
   O(V + E) Memory Usage: 39.9 MB, less than 84.83% of Java online submissions for Course Schedule II.
  */
  static class Kahn {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

      Map<Integer, List<Integer>> graph = new HashMap<>();
      Map<Integer, Integer> inDegree = new HashMap<>();

      for (int i = 0; i < numCourses; i++) {
        graph.put(i, new ArrayList<>());
      }

      for (int[] prerequisite : prerequisites) {
        graph.get(prerequisite[1]).add(prerequisite[0]);
        inDegree.merge(prerequisite[0], 1, Integer::sum);
      }

      Queue<Integer> queue = new ArrayDeque<>();

      for (int i = 0; i < numCourses; i++) {
        if (inDegree.getOrDefault(i, 0) == 0) {
          queue.add(i);
        }
      }

      int currIdx = 0;
      int[] result = new int[numCourses];

      while (!queue.isEmpty()) {

        int curr = queue.remove();
        result[currIdx] = curr;
        currIdx++;

        for (Integer neighbour : graph.get(curr)) {

          int degree = inDegree.merge(neighbour, -1, Integer::sum);
          if (degree == 0) {
            queue.add(neighbour);
          }
        }
      }

      return currIdx == numCourses ? result : new int[0];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
