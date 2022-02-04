package com.leetcode.hashtable.medium;

// Given a binary array nums, return the maximum length of a contiguous subarray
// with an equal number of 0 and 1.
//
//
// Example 1:
//
//
// Input: nums = [0,1]
// Output: 2
// Explanation: [0, 1] is the longest contiguous subarray with an equal number
// of 0 and 1.
//
//
// Example 2:
//
//
// Input: nums = [0,1,0]
// Output: 2
// Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal
// number of 0 and 1.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10⁵
// nums[i] is either 0 or 1.
//
// Related Topics Array Hash Table Prefix Sum 👍 4462 👎 187
/*
  O(n) Runtime: 18 ms, faster than 91.44% of Java online submissions for Contiguous Array.
  O(n) Memory Usage: 51.6 MB, less than 58.69% of Java online submissions for Contiguous Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray_525 {
  public int findMaxLength(int[] nums) {
    Map<Integer, Integer> diffMap = new HashMap<>();

    int result = 0;
    int currDiff = 0;

    diffMap.put(0, -1);

    for (int i = 0; i < nums.length; i++) {
      currDiff += nums[i] == 1 ? 1 : -1;

      if (diffMap.containsKey(currDiff)) {
        result = Math.max(result, i - diffMap.get(currDiff));
      } else {
        diffMap.put(currDiff, i);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
