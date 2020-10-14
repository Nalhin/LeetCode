package com.leetcode.dp.easy;

// You are a professional robber planning to rob houses along a street. Each hous
// e has a certain amount of money stashed, the only constraint stopping you from r
// obbing each of them is that adjacent houses have security system connected and i
// t will automatically contact the police if two adjacent houses were broken into
// on the same night.
//
// Given a list of non-negative integers representing the amount of money of eac
// h house, determine the maximum amount of money you can rob tonight without alert
// ing the police.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//              Total amount you can rob = 1 + 3 = 4.
//
//
// Example 2:
//
//
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
// (money = 1).
//              Total amount you can rob = 2 + 9 + 1 = 12.
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
// Related Topics Dynamic Programming
// 👍 5742 👎 167

// leetcode submit region begin(Prohibit modification and deletion)

public class HouseRobber_198 {
  public int rob(int[] nums) {
    int prev = 0;
    int curr = 0;

    for (int num : nums) {
      int temp = curr;
      curr = Math.max(curr, prev + num);
      prev = temp;
    }
    return curr;
  }
}
/*
 O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
 O(1)  Memory Usage: 36.4 MB, less than 30.16% of Java online submissions for House Robber.
*/
// leetcode submit region end(Prohibit modification and deletion)
