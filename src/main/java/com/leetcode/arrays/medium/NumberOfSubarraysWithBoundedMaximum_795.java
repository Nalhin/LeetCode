package com.leetcode.arrays.medium;

// We are given an array nums of positive integers, and two positive integers lef
// t and right (left <= right).
//
// Return the number of (contiguous, non-empty) subarrays such that the value of
// the maximum array element in that subarray is at least left and at most right.
//
//
//
// Example:
// Input:
// nums = [2, 1, 4, 3]
// left = 2
// right = 3
// Output: 3
// Explanation: There are three subarrays that meet the requirements: [2], [2, 1]
// , [3].
//
//
// Note:
//
//
// left, right, and nums[i] will be an integer in the range [0, 109].
// The length of nums will be in the range of [1, 50000].
//
// Related Topics Array
// 👍 867 👎 58
/*
 O(n) Runtime: 2 ms, faster than 100.00% of Java online submissions for Number of Subarrays with Bounded Maximum.
 O(1) Memory Usage: 46.9 MB, less than 74.53% of Java online submissions for Number of Subarrays with Bounded Maximum.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class NumberOfSubarraysWithBoundedMaximum_795 {
  public int numSubarrayBoundedMax(int[] nums, int left, int right) {
    int leftIdx = -1;
    int rightIdx = -1;
    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > right) {
        leftIdx = i;
      }
      if (nums[i] >= left) {
        rightIdx = i;
      }

      result += rightIdx - leftIdx;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
