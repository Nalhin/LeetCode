package com.leetcode.arrays.easy;

// Given an array consisting of n integers, find the contiguous subarray of given
// length k that has the maximum average value. And you need to output the maximum
// average value.
//
// Example 1:
//
//
// Input: [1,12,-5,-6,50,3], k = 4
// Output: 12.75
// Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
//
//
//
//
// Note:
//
//
// 1 <= k <= n <= 30,000.
// Elements of the given array will be in the range [-10,000, 10,000].
//
//
//
// Related Topics Array
// 👍 891 👎 129

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 2 ms, faster than 92.63% of Java online submissions for Maximum Average Subarray I.
 O(1) Memory Usage: 42.8 MB, less than 96.75% of Java online submissions for Maximum Average Subarray I.
*/
public class MaximumAverageSubarrayI_643 {
  public double findMaxAverage(int[] nums, int k) {
    int max = Integer.MIN_VALUE;

    int curr = 0;
    for (int i = 0; i < k; i++) {
      curr += nums[i];
    }

    for (int i = k; i < nums.length; i++) {
      max = Math.max(curr, max);
      curr -= nums[i - k];
      curr += nums[i];
    }

    return (double) Math.max(curr, max) / k;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
