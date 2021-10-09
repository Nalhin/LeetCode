package com.leetcode.backtracking.medium;

// Given an integer array nums and an integer k, return true if it is possible
// to divide this array into k non-empty subsets whose sums are all equal.
//
//
// Example 1:
//
//
// Input: nums = [4,3,2,3,5,2,1], k = 4
// Output: true
// Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,
// 3) with equal sums.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,4], k = 3
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= k <= nums.length <= 16
// 1 <= nums[i] <= 10⁴
// The frequency of each element is in the range [1, 4].
//
// Related Topics Array Dynamic Programming Backtracking Bit Manipulation
// Memoization Bitmask 👍 3919 👎 227
/*
 O(k * 2^n) Runtime: 6 ms, faster than 34.43% of Java online submissions for Partition to K Equal Sum Subsets.
 O(n) Memory Usage: 36.7 MB, less than 44.41% of Java online submissions for Partition to K Equal Sum Subsets.
*/

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class PartitionToKEqualSumSubsets_698 {
  public boolean backtrack(int[] nums, int k) {
    int sum = Arrays.stream(nums).sum();
    if (sum % k != 0) {
      return false;
    }
    boolean[] visited = new boolean[nums.length];
    Arrays.sort(nums);
    return backtrack(nums, visited, nums.length - 1, sum / k, k, 0, 0);
  }

  private boolean backtrack(
      int[] nums, boolean[] visited, int start, int target, int remaining, int sum, int len) {
    if (remaining == 1) {
      return true;
    }
    if (start < 0) {
      return false;
    }
    if (target == sum && len > 0) {
      return backtrack(nums, visited, nums.length - 1, target, remaining - 1, 0, 0);
    }
    for (int i = start; i >= 0; i--) {
      if (visited[i]) {
        continue;
      }
      visited[i] = true;
      if (backtrack(nums, visited, i - 1, target, remaining, sum + nums[i], len + 1)) {
        return true;
      }
      visited[i] = false;
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
