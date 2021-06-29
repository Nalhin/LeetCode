package com.leetcode.arrays.medium;

// Given a binary array nums and an integer k, return the maximum number of conse
// cutive 1's in the array if you can flip at most k 0's.
//
//
// Example 1:
//
//
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
// Example 2:
//
//
// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length
//
// Related Topics Array Binary Search Sliding Window Prefix Sum
// 👍 2430 👎 38

// leetcode submit region begin(Prohibit modification and deletion)
public class MaxConsecutiveOnesIII_1004 {
  public int longestOnes(int[] nums, int k) {

    int result = 0;
    int left = -1;
    int zeroesInWindow = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        zeroesInWindow++;

        while (zeroesInWindow > k) {
          if (nums[++left] == 0) {
            zeroesInWindow--;
          }
        }
      }
      result = Math.max(result, i - left);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
