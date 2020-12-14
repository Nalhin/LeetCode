package com.leetcode.dp.hard;

// Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number
// on it represented by array nums. You are asked to burst all the balloons. If th
// e you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Her
// e left and right are adjacent indices of i. After the burst, the left and right
// then becomes adjacent.
//
// Find the maximum coins you can collect by bursting the balloons wisely.
//
// Note:
//
//
// You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can n
// ot burst them.
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//
//
// Example:
//
//
// Input: [3,1,5,8]
// Output: 167
// Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// Related Topics Divide and Conquer Dynamic Programming
// 👍 3000 👎 81

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n^3) Runtime: 7 ms, faster than 80.92% of Java online submissions for Burst Balloons.
 O(n^2) Memory Usage: 36.7 MB, less than 72.36% of Java online submissions for Burst Balloons.
*/
public class BurstBalloons_312 {
  public int maxCoins(int[] nums) {
    int n = nums.length + 2;
    int[] nums_with_sides = new int[n];

    for (int i = 0; i < nums.length; i++) {
      nums_with_sides[i + 1] = nums[i];
    }

    nums_with_sides[0] = 1;
    nums_with_sides[n - 1] = 1;

    int[][] dp = new int[n][n];

    for (int left = n - 2; left >= 0; left--)
      for (int right = left + 2; right < n; right++) {
        for (int i = left + 1; i < right; i++)
          dp[left][right] =
              Math.max(
                  dp[left][right],
                  nums_with_sides[left] * nums_with_sides[i] * nums_with_sides[right]
                      + dp[left][i]
                      + dp[i][right]);
      }

    return dp[0][n - 1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
