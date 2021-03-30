package com.leetcode.graph.medium;

// You are given an integer n which indicates that we have n courses, labeled fro
// m 1 to n. You are also given an array relations where relations[i] = [a, b], rep
// resenting a prerequisite relationship between course a and course b: course a ha
// s to be studied before course b.
//
// In one semester, you can study any number of courses as long as you have stud
// ied all the prerequisites for the course you are studying.
//
// Return the minimum number of semesters needed to study all courses. If there
// is no way to study all the courses, return -1.
//
//
// Example 1:
//
//
// Input: n = 3, relations = [[1,3],[2,3]]
// Output: 2
// Explanation: In the first semester, courses 1 and 2 are studied. In the second
// semester, course 3 is studied.
//
//
// Example 2:
//
//
// Input: n = 3, relations = [[1,2],[2,3],[3,1]]
// Output: -1
// Explanation: No course can be studied because they depend on each other.
//
//
//
// Constraints:
//
//
// 1 <= n <= 5000
// 1 <= relations.length <= 5000
// 1 <= a, b <= n
// a != b
// All the pairs [a, b] are unique.
// Related Topics Dynamic Programming Depth-first Search Graph
// 👍 345 👎 12
/*
  O(V + E) Runtime: 4 ms, faster than 100.00% of Java online submissions for Parallel Courses.
  O(V + E) Memory Usage: 39.6 MB, less than 92.92% of Java online submissions for Parallel Courses.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class ParallelCourses_1136 {
  public int minimumSemesters(int n, int[][] relations) {
    List<List<Integer>> graph = new ArrayList<>(n + 1);
    for (int i = 0; i < n + 1; ++i) {
      graph.add(new ArrayList<>());
    }
    for (int[] relation : relations) {
      graph.get(relation[0]).add(relation[1]);
    }

    int result = 1;
    int[] distance = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      int newDist = dfs(graph, distance, i);
      if (newDist == -1) {
        return -1;
      }
      result = Math.max(result, newDist);
    }
    return result;
  }

  private int dfs(List<List<Integer>> graph, int[] distance, int position) {
    if (distance[position] != 0) {
      return distance[position];
    }

    distance[position] = -1;

    int maxDistance = 1;
    for (int num : graph.get(position)) {
      int newDistance = dfs(graph, distance, num);
      if (newDistance == -1) {
        return newDistance;
      }
      maxDistance = Math.max(maxDistance, newDistance + 1);
    }
    distance[position] = maxDistance;

    return distance[position];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
