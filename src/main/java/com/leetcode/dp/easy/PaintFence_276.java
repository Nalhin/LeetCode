package com.leetcode.dp.easy;
// There is a fence with n posts, each post can be painted with one of the k colo
// rs.
//
// You have to paint all the posts such that no more than two adjacent fence pos
// ts have the same color.
//
// Return the total number of ways you can paint the fence.
//
// Note:
// n and k are non-negative integers.
//
// Example:
//
//
// Input: n = 3, k = 2
// Output: 6
// Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:
//
//             post1  post2  post3
// -----      -----  -----  -----
//   1         c1     c1     c2
//    2         c1     c2     c1
//    3         c1     c2     c2
//    4         c2     c1     c1
//   5         c2     c1     c2
//    6         c2     c2     c1
//
// Related Topics Dynamic Programming
// 👍 829 👎 262
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Paint Fence.
 O(n) Memory Usage: 35.5 MB, less than 84.22% of Java online submissions for Paint Fence.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class PaintFence_276 {
  public int numWays(int n, int k) {
    if (n == 0) {
      return 0;
    }
    int[][] dp = new int[n + 1][2];
    dp[1][0] = k;

    for (int i = 2; i < dp.length; i++) {
      dp[i][0] = (dp[i - 1][1] + dp[i - 1][0]) * (k - 1);
      dp[i][1] = dp[i - 1][0];
    }

    return dp[n][0] + dp[n][1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
