package com.leetcode.arrays.easy;
// Given a binary array, find the maximum number of consecutive 1s in this array.
//
//
// Example 1:
//
// Input: [1,1,0,1,1,1]
// Output: 3
// Explanation: The first two digits or the last three digits are consecutive 1s.
//
//    The maximum number of consecutive 1s is 3.
//
//
//
// Note:
//
// The input array will only contain 0 and 1.
// The length of input array is a positive integer and will not exceed 10,000
//
// Related Topics Array
// 👍 811 👎 370

// leetcode submit region begin(Prohibit modification and deletion)
public class MaxConsecutiveOnes_485 {
  public int findMaxConsecutiveOnes(int[] nums) {
    int max = 0;
    int curr = 0;
    for (int num : nums) {
      if (num == 1) {
        curr++;
      } else {
        max = Math.max(curr, max);
        curr = 0;
      }
    }
    return Math.max(curr, max);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
