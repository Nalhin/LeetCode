package com.leetcode.dp.medium;

// Given an integer array nums, return the length of the longest strictly increas
// ing subsequence.
//
// A subsequence is a sequence that can be derived from an array by deleting som
// e or no elements without changing the order of the remaining elements. For examp
// le, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
//
//
// Example 1:
//
//
// Input: nums = [10,9,2,5,3,7,101,18]
// Output: 4
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the
// length is 4.
//
//
// Example 2:
//
//
// Input: nums = [0,1,0,3,2,3]
// Output: 4
//
//
// Example 3:
//
//
// Input: nums = [7,7,7,7,7,7,7]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2500
// -104 <= nums[i] <= 104
//
//
//
// Follow up:
//
//
// Could you come up with the O(n2) solution?
// Could you improve it to O(n log(n)) time complexity?
//
// Related Topics Binary Search Dynamic Programming
// 👍 6022 👎 138

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
public class LongestIncreasingSubsequence_300 {
  /*
   O(n) Runtime: 54 ms, faster than 29.66% of Java online submissions for Longest Increasing Subsequence.
   O(n) Memory Usage: 38.8 MB, less than 25.00% of Java online submissions for Longest Increasing Subsequence.
  */
  static class NaiveDp {
    public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      int result = 0;
      for (int i = 0; i < nums.length; i++) {
        int max = 1;
        for (int j = 0; j <= i; j++) {
          if (nums[j] < nums[i]) {
            max = Math.max(max, dp[j] + 1);
          }
        }
        dp[i] = max;
        result = Math.max(max, result);
      }
      return result;
    }
  }

  static class BinarySearchDp {

    public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      int len = 0;
      for (int num : nums) {
        int insert = Arrays.binarySearch(dp, 0, len, num);
        if (insert < 0) {
          insert = -(insert + 1);
        }
        dp[insert] = num;
        if (insert == len) {
          len++;
        }
      }
      return len;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
