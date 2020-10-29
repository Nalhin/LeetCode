package com.leetcode.dp.easy;

//
// On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 i
// ndexed).
//
// Once you pay the cost, you can either climb one or two steps. You need to find
// minimum cost to reach the top of the floor, and you can either start from the s
// tep with index 0, or the step with index 1.
//
//
// Example 1:
//
// Input: cost = [10, 15, 20]
// Output: 15
// Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
//
//
//
// Example 2:
//
// Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
// Output: 6
// Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[
// 3].
//
//
//
// Note:
//
// cost will have a length in the range [2, 1000].
// Every cost[i] will be an integer in the range [0, 999].
//
// Related Topics Array Dynamic Programming
// 👍 2476 👎 528

// leetcode submit region begin(Prohibit modification and deletion)

// leetcode submit region end(Prohibit modification and deletion)
/*
 O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Min Cost Climbing Stairs.
 O(1)  Memory Usage: 39 MB, less than 11.48% of Java online submissions for Min Cost Climbing Stairs.
*/
public class MinCostClimbingStairs_746 {
  public int minCostClimbingStairs(int[] cost) {
    int prevPrev = cost[0];
    int prev = cost[1];
    for (int i = 2; i < cost.length; i++) {
      int temp = prev;
      prev = Math.min(prev, prevPrev) + cost[i];
      prevPrev = temp;
    }

    return Math.min(prev, prevPrev);
  }
}
