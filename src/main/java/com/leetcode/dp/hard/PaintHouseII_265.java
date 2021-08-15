package com.leetcode.dp.hard;

// There are a row of n houses, each house can be painted with one of the k color
// s. The cost of painting each house with a certain color is different. You have t
// o paint all the houses such that no two adjacent houses have the same color.
//
// The cost of painting each house with a certain color is represented by an n x
// k cost matrix costs.
//
//
// For example, costs[0][0] is the cost of painting house 0 with color 0; costs[
// 1][2] is the cost of painting house 1 with color 2, and so on...
//
//
// Return the minimum cost to paint all houses.
//
//
// Example 1:
//
//
// Input: costs = [[1,5,3],[2,9,4]]
// Output: 5
// Explanation:
// Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 =
// 5;
// Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2
// = 5.
//
//
// Example 2:
//
//
// Input: costs = [[1,3],[2,4]]
// Output: 5
//
//
//
// Constraints:
//
//
// costs.length == n
// costs[i].length == k
// 1 <= n <= 100
// 1 <= k <= 20
// 1 <= costs[i][j] <= 20
//
//
//
// Follow up: Could you solve it in O(nk) runtime?
// Related Topics Array Dynamic Programming
// 👍 723 👎 30
/*
 O(n * k) Runtime: 3 ms, faster than 44.48% of Java online submissions for Paint House II.
 O(k) Memory Usage: 38.9 MB, less than 83.27% of Java online submissions for Paint House II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class PaintHouseII_265 {
  public int minCostII(int[][] costs) {
    int k = costs[0].length;
    int[] dp = new int[k];

    for (int i = 0; i < k; i++) {
      dp[i] = costs[0][i];
    }

    for (int i = 1; i < costs.length; i++) {
      int[] minAndSecondMin = findMinAndSecondMinIdx(dp);
      int minIdx = minAndSecondMin[0];
      int secondMinIdx = minAndSecondMin[1];

      int[] newDp = new int[k];
      for (int j = 0; j < k; j++) {
        if (j == minIdx) {
          newDp[j] = costs[i][j] + dp[secondMinIdx];
        } else {
          newDp[j] = costs[i][j] + dp[minIdx];
        }
      }
      dp = newDp;
    }

    return Arrays.stream(dp).min().getAsInt();
  }

  private int[] findMinAndSecondMinIdx(int[] prev) {
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    int firstIdx = -1;
    int secondIdx = -1;
    for (int i = 0; i < prev.length; i++) {
      if (prev[i] < firstMin) {
        secondMin = firstMin;
        secondIdx = firstIdx;
        firstMin = prev[i];
        firstIdx = i;
      } else if (prev[i] < secondMin) {
        secondMin = prev[i];
        secondIdx = i;
      }
    }

    return new int[] {firstIdx, secondIdx};
  }
}

// leetcode submit region end(Prohibit modification and deletion)
