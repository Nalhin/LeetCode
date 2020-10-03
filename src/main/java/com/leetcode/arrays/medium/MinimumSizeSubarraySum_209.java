package com.leetcode.arrays.medium;

// Given an array of n positive integers and a positive integer s, find the minim
// al length of a contiguous subarray of which the sum ≥ s. If there isn't one, ret
// urn 0 instead.
//
// Example:
//
//
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem const
// raint.
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution of whi
// ch the time complexity is O(n log n).
// Related Topics Array Two Pointers Binary Search
// 👍 2812 👎 121

// leetcode submit region begin(Prohibit modification and deletion)

public class MinimumSizeSubarraySum_209 {
  public int minSubArrayLen(int s, int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int result = Integer.MAX_VALUE;
    int slow = 0, sum = 0;

    for (int fast = 0; fast < nums.length; fast++) {
      sum += nums[fast];
      while (sum >= s) {
        result = Math.min(result, fast + 1 - slow);
        sum -= nums[slow++];
      }
    }

    return result;
  }
}
/*
   O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Size Subarray Sum.
   O(1) Memory Usage: 41.6 MB, less than 21.39% of Java online submissions for Minimum Size Subarray Sum.
*/
// leetcode submit region end(Prohibit modification and deletion)
