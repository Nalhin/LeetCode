package com.leetcode.dp.medium;

// You are a professional robber planning to rob houses along a street. Each hous
// e has a certain amount of money stashed. All houses at this place are arranged i
// n a circle. That means the first house is the neighbor of the last one. Meanwhil
// e, adjacent houses have a security system connected, and it will automatically c
// ontact the police if two adjacent houses were broken into on the same night.
//
// Given a list of non-negative integers nums representing the amount of money o
// f each house, return the maximum amount of money you can rob tonight without ale
// rting the police.
//
//
// Example 1:
//
//
// Input: nums = [2,3,2]
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
// 2), because they are adjacent houses.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
//
//
// Example 3:
//
//
// Input: nums = [0]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 1000
//
// Related Topics Dynamic Programming
// 👍 2164 👎 54

// leetcode submit region begin(Prohibit modification and deletion)

public class HouseRobberII_213 {
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    return Math.max(maxFromRound(nums, 1, nums.length - 1), maxFromRound(nums, 0, nums.length - 2));
  }

  private int maxFromRound(int[] nums, int start, int end) {
    int prev = 0;
    int curr = 0;

    for (int i = start; i <= end; i++) {
      int prevCurr = curr;
      curr = Math.max(curr, prev + nums[i]);
      prev = prevCurr;
    }

    return curr;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
