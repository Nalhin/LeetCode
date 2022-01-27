package com.leetcode.bitmanipulation.medium;

// Given an integer array nums, return the maximum result of nums[i] XOR nums[j],
// where 0 <= i <= j < n.
//
//
// Example 1:
//
//
// Input: nums = [3,10,5,25,2,8]
// Output: 28
// Explanation: The maximum result is 5 XOR 25 = 28.
//
//
// Example 2:
//
//
// Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
// Output: 127
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 2 * 10⁵
// 0 <= nums[i] <= 2³¹ - 1
//
// Related Topics Array Hash Table Bit Manipulation Trie 👍 3521 👎 300
/*
  O(nlog(W)) Runtime: 44 ms, faster than 98.21% of Java online submissions for Maximum XOR of Two Numbers in an Array.
  O(n)  Memory Usage: 90.1 MB, less than 44.69% of Java online submissions for Maximum XOR of Two Numbers in an Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashSet;

public class MaximumXOROfTwoNumbersInAnArray_421 {
  public int findMaximumXOR(int[] nums) {
    int maxLen = Integer.toBinaryString(Arrays.stream(nums).max().getAsInt()).length();

    int result = 0;

    for (int i = maxLen - 1; i >= 0; i--) {
      result <<= 1;
      int currBitMask = result | 1;

      HashSet<Integer> prefixes = new HashSet<>();
      for (int num : nums) {

        int prefix = num >> i;

        if (prefixes.contains(prefix ^ currBitMask)) {
          result = currBitMask;
          break;
        }

        prefixes.add(prefix);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
