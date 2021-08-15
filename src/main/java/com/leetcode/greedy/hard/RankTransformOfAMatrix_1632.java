package com.leetcode.greedy.hard;

// Given an m x n matrix, return a new matrix answer where answer[row][col] is th
// e rank of matrix[row][col].
//
// The rank is an integer that represents how large an element is compared to ot
// her elements. It is calculated using the following rules:
//
//
// The rank is an integer starting from 1.
// If two elements p and q are in the same row or column, then:
//
// If p < q then rank(p) < rank(q)
// If p == q then rank(p) == rank(q)
// If p > q then rank(p) > rank(q)
//
//
// The rank should be as small as possible.
//
//
// It is guaranteed that answer is unique under the given rules.
//
//
// Example 1:
//
//
// Input: matrix = [[1,2],[3,4]]
// Output: [[1,2],[2,3]]
// Explanation:
// The rank of matrix[0][0] is 1 because it is the smallest integer in its row an
// d column.
// The rank of matrix[0][1] is 2 because matrix[0][1] > matrix[0][0] and matrix[0
// ][0] is rank 1.
// The rank of matrix[1][0] is 2 because matrix[1][0] > matrix[0][0] and matrix[0
// ][0] is rank 1.
// The rank of matrix[1][1] is 3 because matrix[1][1] > matrix[0][1], matrix[1][1
// ] > matrix[1][0], and both matrix[0][1] and matrix[1][0] are rank 2.
//
//
// Example 2:
//
//
// Input: matrix = [[7,7],[7,7]]
// Output: [[1,1],[1,1]]
//
//
// Example 3:
//
//
// Input: matrix = [[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]
// Output: [[4,2,3],[1,3,4],[5,1,6],[1,3,4]]
//
//
// Example 4:
//
//
// Input: matrix = [[7,3,6],[1,4,5],[9,8,2]]
// Output: [[5,1,4],[1,2,3],[6,3,1]]
//
//
//
// Constraints:
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 500
// -109 <= matrix[row][col] <= 109
//
// Related Topics Array Greedy Union Find Graph Topological Sort Matrix
// 👍 476 👎 28
/*
 O(nmlog(nm)) Runtime: 199 ms, faster than 43.25% of Java online submissions for Rank Transform of a Matrix.
 O(nm) Memory Usage: 84.9 MB, less than 26.25% of Java online submissions for Rank Transform of a Matrix.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class RankTransformOfAMatrix_1632 {
  public int[][] matrixRankTransform(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;

    Map<Integer, Map<Integer, List<Integer>>> graphs = new HashMap<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int v = matrix[i][j];

        if (!graphs.containsKey(v)) {
          graphs.put(v, new HashMap<>());
        }
        Map<Integer, List<Integer>> graph = graphs.get(v);
        if (!graph.containsKey(i)) {
          graph.put(i, new ArrayList<>());
        }
        if (!graph.containsKey(~j)) {
          graph.put(~j, new ArrayList<>());
        }

        graph.get(i).add(~j);
        graph.get(~j).add(i);
      }
    }

    Map<Integer, List<List<int[]>>> value2index = new TreeMap<>();
    boolean[][] seen = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (seen[i][j]) {
          continue;
        }
        seen[i][j] = true;
        int v = matrix[i][j];
        Map<Integer, List<Integer>> graph = graphs.get(v);

        Set<Integer> rowsCols = new HashSet<>();
        rowsCols.add(i);
        rowsCols.add(~j);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        queue.offer(~j);
        while (!queue.isEmpty()) {
          int node = queue.poll();
          for (int rowCol : graph.get(node)) {
            if (!rowsCols.contains(rowCol)) {
              rowsCols.add(rowCol);
              queue.offer(rowCol);
            }
          }
        }

        List<int[]> points = new ArrayList<>();
        for (int rowCol : rowsCols) {
          for (int k : graph.get(rowCol)) {
            if (k >= 0) {
              points.add(new int[] {k, ~rowCol});
              seen[k][~rowCol] = true;
            } else {
              points.add(new int[] {rowCol, ~k});
              seen[rowCol][~k] = true;
            }
          }
        }
        if (!value2index.containsKey(v)) {
          value2index.put(v, new ArrayList<>());
        }
        value2index.get(v).add(points);
      }
    }
    int[][] result = new int[m][n];
    int[] rowMax = new int[m];
    int[] colMax = new int[n];
    for (int key : value2index.keySet()) {
      for (List<int[]> points : value2index.get(key)) {
        int rank = 1;
        for (int[] point : points) {
          rank = Math.max(rank, Math.max(rowMax[point[0]], colMax[point[1]]) + 1);
        }
        for (int[] point : points) {
          result[point[0]][point[1]] = rank;

          rowMax[point[0]] = Math.max(rowMax[point[0]], rank);
          colMax[point[1]] = Math.max(colMax[point[1]], rank);
        }
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
