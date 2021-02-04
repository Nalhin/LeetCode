package com.leetcode.hashtable.easy;

// We define a harmonious array as an array where the difference between its maxi
// mum value and its minimum value is exactly 1.
//
// Given an integer array nums, return the length of its longest harmonious subs
// equence among all its possible subsequences.
//
// A subsequence of array is a sequence that can be derived from the array by de
// leting some or no elements without changing the order of the remaining elements.
//
//
//
// Example 1:
//
//
// Input: nums = [1,3,2,2,5,2,3,7]
// Output: 5
// Explanation: The longest harmonious subsequence is [3,2,2,2,3].
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,4]
// Output: 2
//
//
// Example 3:
//
//
// Input: nums = [1,1,1,1]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 104
// -109 <= nums[i] <= 109
//
// Related Topics Hash Table
// 👍 898 👎 99

import java.util.HashMap;
import java.util.Map;
/*
 O(n) Runtime: 32 ms, faster than 23.92% of Java online submissions for Longest Harmonious Subsequence.
 O(n) Memory Usage: 62.2 MB, less than 13.01% of Java online submissions for Longest Harmonious Subsequence.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class LongestHarmoniousSubsequence_594 {
  public int findLHS(int[] nums) {
    Map<Integer, Integer> counter = new HashMap<>();

    for (int num : nums) {
      counter.put(num, counter.getOrDefault(num, 0) + 1);
    }

    int result = 0;
    for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
      if (counter.containsKey(entry.getKey() + 1)) {
        result = Math.max(result, entry.getValue() + counter.get(entry.getKey() + 1));
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
