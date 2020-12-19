package com.leetcode.dp.medium;

// There is a row of n houses, where each house can be painted one of three color
// s: red, blue, or green. The cost of painting each house with a certain color is
// different. You have to paint all the houses such that no two adjacent houses hav
// e the same color.
//
// The cost of painting each house with a certain color is represented by a n x
// 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with the
// color red; costs[1][2] is the cost of painting house 1 with color green, and so
// on... Find the minimum cost to paint all houses.
//
//
// Example 1:
//
//
// Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
// Output: 10
// Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2
// into blue.
// Minimum cost: 2 + 5 + 3 = 10.
//
//
// Example 2:
//
//
// Input: costs = []
// Output: 0
//
//
// Example 3:
//
//
// Input: costs = [[7,6,2]]
// Output: 2
//
//
//
// Constraints:
//
//
// costs.length == n
// costs[i].length == 3
// 0 <= n <= 100
// 1 <= costs[i][j] <= 20
//
// Related Topics Dynamic Programming
// 👍 1044 👎 93

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(n) Runtime: 2 ms, faster than 15.58% of Java online submissions for Paint House.
 O(1) Memory Usage: 38.5 MB, less than 51.88% of Java online submissions for Paint House.
*/
public class PaintHouse_256 {
  public int minCost(int[][] costs) {
    if (costs.length <= 0) {
      return 0;
    }

    int[] dp = costs[0];
    for (int i = 1; i < costs.length; i++) {
      int[] temp = new int[3];
      temp[2] = Math.min(dp[0], dp[1]) + costs[i][2];
      temp[1] = Math.min(dp[0], dp[2]) + costs[i][1];
      temp[0] = Math.min(dp[1], dp[2]) + costs[i][0];
      dp = temp;
    }

    return Arrays.stream(dp).min().orElse(0);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
