package com.leetcode.dp.medium;
// Given an integer array nums, return the number of longest increasing subsequen
// ces.
//
//
// Example 1:
//
//
// Input: nums = [1,3,5,4,7]
// Output: 2
// Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1,
// 3, 5, 7].
//
//
// Example 2:
//
//
// Input: nums = [2,2,2,2,2]
// Output: 5
// Explanation: The length of longest continuous increasing subsequence is 1, and
// there are 5 subsequences' length is 1, so output 5.
//
//
//
//
// Constraints:
//
//
// 0 <= nums.length <= 2000
// -106 <= nums[i] <= 106
//
// Related Topics Dynamic Programming
// 👍 1821 👎 99

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(n^2) Runtime: 18 ms, faster than 34.07% of Java online submissions for Number of Longest Increasing Subsequence.
 O(n) Memory Usage: 38.8 MB, less than 12.45% of Java online submissions for Number of Longest Increasing Subsequence.
*/
public class NumberOfLongestIncreasingSubsequence_673 {
  public int findNumberOfLIS(int[] nums) {
    int n = nums.length;
    if (n <= 1) {
      return n;
    }

    int[] lengths = new int[n];
    int[] counts = new int[n];

    Arrays.fill(counts, 1);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (lengths[i] <= lengths[j]) {
            lengths[i] = lengths[j] + 1;
            counts[i] = counts[j];
          } else if (lengths[j] + 1 == lengths[i]) {
            counts[i] += counts[j];
          }
        }
      }
    }

    int maxLen = Arrays.stream(lengths).max().getAsInt();
    int result = 0;
    for (int i = 0; i < lengths.length; i++) {
      if (lengths[i] == maxLen) {
        result += counts[i];
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
