package com.leetcode.arrays.easy;

// In a given integer array nums, there is always exactly one largest element.
//
// Find whether the largest element in the array is at least twice as much as ev
// ery other number in the array.
//
// If it is, return the index of the largest element, otherwise return -1.
//
// Example 1:
//
//
// Input: nums = [3, 6, 1, 0]
// Output: 1
// Explanation: 6 is the largest integer, and for every other number in the array
// x,
// 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
//
//
//
//
// Example 2:
//
//
// Input: nums = [1, 2, 3, 4]
// Output: -1
// Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
//
//
//
//
//
// Note:
//
//
// nums will have a length in the range [1, 50].
// Every nums[i] will be an integer in the range [0, 99].
//
//
//
// Related Topics Array
// 👍 354 👎 597

// leetcode submit region begin(Prohibit modification and deletion)

public class LargestNumberAtLeastTwiceOfOthers_747 {
  public int dominantIndex(int[] nums) {
    int max = nums[0];
    int secondMax = 0;
    int maxIndex = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > max) {
        secondMax = max;
        max = nums[i];
        maxIndex = i;
      } else if (nums[i] > secondMax) {
        secondMax = nums[i];
      }
    }

    return secondMax * 2 > max ? -1 : maxIndex;
  }
}
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Number At Least Twice of Others.
  O(1)Memory Usage: 37 MB, less than 96.24% of Java online submissions for Largest Number At Least Twice of Others.
*/
// leetcode submit region end(Prohibit modification and deletion)
