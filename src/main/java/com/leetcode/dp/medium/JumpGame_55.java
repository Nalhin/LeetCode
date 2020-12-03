package com.leetcode.dp.medium;

// Given an array of non-negative integers, you are initially positioned at the f
// irst index of the array.
//
// Each element in the array represents your maximum jump length at that positio
// n.
//
// Determine if you are able to reach the last index.
//
//
// Example 1:
//
//
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jum
// p length is 0, which makes it impossible to reach the last index.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 10^4
// 0 <= nums[i][j] <= 10^5
//
// Related Topics Array Greedy
// 👍 5268 👎 373

// leetcode submit region begin(Prohibit modification and deletion)

public class JumpGame_55 {

  /*
   O(n) Runtime: 1 ms, faster than 82.02% of Java online submissions for Jump Game.
   O(n) Memory Usage: 41.5 MB, less than 19.98% of Java online submissions for Jump Game.
  */
  static class Dp {
    public boolean canJump(int[] nums) {
      boolean[] dp = new boolean[nums.length];

      dp[0] = true;

      for (int i = 0; i < dp.length; i++) {
        if (dp[i]) {
          for (int j = Math.min(i + nums[i], dp.length - 1); !dp[j]; j--) {
            dp[j] = true;
          }
        }
      }
      return dp[dp.length - 1];
    }
  }

  /*
   O(n) Runtime: 1 ms, faster than 82.02% of Java online submissions for Jump Game.
   O(1) Memory Usage: 41.5 MB, less than 19.98% of Java online submissions for Jump Game.
  */
  static class Greedy {

    public boolean canJump(int[] nums) {
      int farthest = 0;
      for (int i = 0; i < nums.length; i++) {
        if (farthest >= i) {
          farthest = Math.max(farthest, i + nums[i]);
        }
      }
      return farthest >= nums.length - 1;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
