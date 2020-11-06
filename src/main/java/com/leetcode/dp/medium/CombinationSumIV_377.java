package com.leetcode.dp.medium;

// Given an integer array with all positive numbers and no duplicates, find the n
// umber of possible combinations that add up to a positive integer target.
//
// Example:
//
//
// nums = [1, 2, 3]
// target = 4
//
// The possible combination ways are:
// (1, 1, 1, 1)
// (1, 1, 2)
// (1, 2, 1)
// (1, 3)
// (2, 1, 1)
// (2, 2)
// (3, 1)
//
// Note that different sequences are counted as different combinations.
//
// Therefore the output is 7.
//
//
//
//
// Follow up:
// What if negative numbers are allowed in the given array?
// How does it change the problem?
// What limitation we need to add to the question to allow negative numbers?
//
// Credits:
// Special thanks to @pbrother for adding this problem and creating all test case
// s.
// Related Topics Dynamic Programming
// 👍 1697 👎 206

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n*m) Runtime: 1 ms, faster than 81.40% of Java online submissions for Combination Sum IV.
  O(m)   Memory Usage: 36.4 MB, less than 24.38% of Java online submissions for Combination Sum IV.
  where:
  m - target sum
*/
public class CombinationSumIV_377 {
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];

    for (int num : nums) {
      if (num < dp.length) {
        dp[num] = 1;
      }
    }

    for (int i = 1; i < dp.length; i++) {
      for (int num : nums) {
        int next = i + num;

        if (next < dp.length && dp[i] > 0) {
          dp[next] += dp[i];
        }
      }
    }
    return dp[target];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
