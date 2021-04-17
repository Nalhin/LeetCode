package com.leetcode.hashtable.hard;

// Given a matrix and a target, return the number of non-empty submatrices that s
// um to target.
//
// A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
// <= x2 and y1 <= y <= y2.
//
// Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if th
// ey have some coordinate that is different: for example, if x1 != x1'.
//
//
// Example 1:
//
//
// Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
// Output: 4
// Explanation: The four 1x1 submatrices that only contain 0.
//
//
// Example 2:
//
//
// Input: matrix = [[1,-1],[-1,1]], target = 0
// Output: 5
// Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2
// x2 submatrix.
//
//
// Example 3:
//
//
// Input: matrix = [[904]], target = 0
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= matrix.length <= 100
// 1 <= matrix[0].length <= 100
// -1000 <= matrix[i] <= 1000
// -10^8 <= target <= 10^8
//
// Related Topics Array Dynamic Programming Sliding Window
// 👍 933 👎 31
/*

 O(n * n * m) Runtime: 104 ms, faster than 59.07% of Java online submissions for Number of Submatrices That Sum to Target.
 O(n * m) Memory Usage: 40.1 MB, less than 31.24% of Java online submissions for Number of Submatrices That Sum to Target.

*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget_1074 {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] dp = new int[rows + 1][cols + 1];

    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int result = 0;

    for (int i = 1; i <= rows; i++) {
      for (int j = i; j <= rows; j++) {

        map.clear();
        map.put(0, 1);

        for (int k = 1; k <= cols; k++) {
          int curr = dp[j][k] - dp[i - 1][k];
          result += map.getOrDefault(curr - target, 0);
          map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
