package com.leetcode.arrays.medium;

// Given a non-empty array nums containing only positive integers, find if the ar
// ray can be partitioned into two subsets such that the sum of elements in both su
// bsets is equal.
//
//
// Example 1:
//
//
// Input: nums = [1,5,11,5]
// Output: true
// Explanation: The array can be partitioned as [1, 5, 5] and [11].
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,5]
// Output: false
// Explanation: The array cannot be partitioned into equal sum subsets.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
//
// Related Topics Dynamic Programming
// 👍 3519 👎 78

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
  O(n) Runtime: 15 ms, faster than 80.01% of Java online submissions for Partition Equal Subset Sum.
  O(n) Memory Usage: 38.2 MB, less than 85.62% of Java online submissions for Partition Equal Subset Sum.
 */
public class PartitionEqualSubsetSum_416 {
  public boolean canPartition(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    if (sum % 2 == 1) {
      return false;
    }
    int target = sum / 2;
    boolean[] dp = new boolean[target + 1];
    dp[0] = true;

    for (int num : nums) {
      for (int j = target; j >= num; j--) {
        if (j - num >= 0 && dp[j - num]) {
          dp[j] = true;
        }
      }
    }

    return dp[target];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
