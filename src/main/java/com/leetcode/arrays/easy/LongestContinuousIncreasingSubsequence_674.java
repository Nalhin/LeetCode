package com.leetcode.arrays.easy;

// Given an unsorted array of integers nums, return the length of the longest con
// tinuous increasing subsequence (i.e. subarray). The subsequence must be strictly
// increasing.
//
// A continuous increasing subsequence is defined by two indices l and r (l < r)
// such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each
// l <= i < r, nums[i] < nums[i + 1].
//
//
// Example 1:
//
//
// Input: nums = [1,3,5,4,7]
// Output: 3
// Explanation: The longest continuous increasing subsequence is [1,3,5] with len
// gth 3.
// Even though [1,3,5,7] is an increasing subsequence, it is not continuous as el
// ements 5 and 7 are separated by element
// 4.
//
//
// Example 2:
//
//
// Input: nums = [2,2,2,2,2]
// Output: 1
// Explanation: The longest continuous increasing subsequence is [2] with length
// 1. Note that it must be strictly
// increasing.
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 104
// -109 <= nums[i] <= 109
//
// Related Topics Array
// 👍 1003 👎 131

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 98.29% of Java online submissions for Longest Continuous Increasing Subsequence.
 O(1) Memory Usage: 39.8 MB, less than 55.32% of Java online submissions for Longest Continuous Increasing Subsequence.
*/
public class LongestContinuousIncreasingSubsequence_674 {
  public int findLengthOfLCIS(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int max = 0;
    int start = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] >= nums[i]) {
        start = i;
      }
      max = Math.max(max, i - start);
    }
    return max + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
