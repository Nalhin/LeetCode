package com.leetcode.dp.medium;

// Given an integer array arr and an integer difference, return the length of the
// longest subsequence in arr which is an arithmetic sequence such that the differ
// ence between adjacent elements in the subsequence equals difference.
//
//
// Example 1:
//
//
// Input: arr = [1,2,3,4], difference = 1
// Output: 4
// Explanation: The longest arithmetic subsequence is [1,2,3,4].
//
// Example 2:
//
//
// Input: arr = [1,3,5,7], difference = 1
// Output: 1
// Explanation: The longest arithmetic subsequence is any single element.
//
//
// Example 3:
//
//
// Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
// Output: 4
// Explanation: The longest arithmetic subsequence is [7,5,3,1].
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 10^5
// -10^4 <= arr[i], difference <= 10^4
//
// Related Topics Math Dynamic Programming
// 👍 424 👎 29

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*
 O(n) Runtime: 36 ms, faster than 76.40% of Java online submissions for Longest Arithmetic Subsequence of Given Difference.
 O(n) Memory Usage: 56.7 MB, less than 24.40% of Java online submissions for Longest Arithmetic Subsequence of Given Difference.
*/
public class LongestArithmeticSubsequenceOfGivenDifference_1218 {
  public int longestSubsequence(int[] arr, int difference) {
    Map<Integer, Integer> dp = new HashMap<>();

    for (int num : arr) {
      int prev = dp.getOrDefault(num - difference, 0);
      dp.put(num, prev + 1);
    }

    return Collections.max(dp.values());
  }
}

// leetcode submit region end(Prohibit modification and deletion)
