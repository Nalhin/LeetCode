package com.leetcode.dp.medium;

// You are given a list of non-negative integers, a1, a2, ..., an, and a target,
// S. Now you have 2 symbols + and -. For each integer, you should choose one from
// + and - as its new symbol.
//
// Find out how many ways to assign symbols to make sum of integers equal to tar
// get S.
//
// Example 1:
//
//
// Input: nums is [1, 1, 1, 1, 1], S is 3.
// Output: 5
// Explanation:
//
// -1+1+1+1+1 = 3
// +1-1+1+1+1 = 3
// +1+1-1+1+1 = 3
// +1+1+1-1+1 = 3
// +1+1+1+1-1 = 3
//
// There are 5 ways to assign symbols to make the sum of nums be target 3.
//
//
//
// Constraints:
//
//
// The length of the given array is positive and will not exceed 20.
// The sum of elements in the given array will not exceed 1000.
// Your output answer is guaranteed to be fitted in a 32-bit integer.
//
// Related Topics Dynamic Programming Depth-first Search
// 👍 3240 👎 131

import java.util.HashMap;
import java.util.Map;

// leetcode submit region begin(Prohibit modification and deletion)
/*

  O(n + m) Runtime: 8 ms, faster than 80.09% of Java online submissions for Target Sum.
  O(m) Memory Usage: 38.8 MB, less than 5.17% of Java online submissions for Target Sum.
  where:
  m = 2001
*/
public class TargetSum_494 {
  public int findTargetSumWays(int[] nums, int S) {
    if (S > 1000) {
      return 0;
    }
    int[] dp = new int[2001];
    dp[nums[0] + 1000] = 1;
    dp[-nums[0] + 1000] += 1;

    for (int i = 1; i < nums.length; i++) {
      int[] newDp = new int[2001];
      for (int j = -1000; j < 1000; j++) {
        if (dp[j + 1000] > 0) {
          newDp[j + nums[i] + 1000] += dp[j + 1000];
          newDp[j - nums[i] + 1000] += dp[j + 1000];
        }
      }
      dp = newDp;
    }
    return dp[S + 1000];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
